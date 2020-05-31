<!--
 * @Author: your name
 * @Date: 2020-05-28 16:38:50
 * @LastEditTime: 2020-05-28 18:29:32
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/Solutions/BinarySearch/704_BinarySearch/Solution.md
--> 

# 二分查找分析
## 关于“取中点”
一行基本不变的核心代码：
``` java
int mid = low + (high - low) / 2;
```

注意这行代码隐藏了一些重要的信息，mid 与 low、high 的大小关系是怎样的？

**更直接地说，mid 一定位于 low 与 high 中间吗？**

**不一定，因为这不是真正的取中点操作，我们是向下取整。**

具体分析：
1. 一般来说 high >= low，即 **mid >= low**
2. 因为 /2 是向下取整，**mid <= high**

推论：
存在 low = mid 场景，要求 (high - low) / 2 = 0

## 两种需要注意的特殊场景
1. high = low 时（数组中有单个元素），mid = low 且 mid = high
2. high - low = 1（数组中有两个元素）时，mid = low

下面来看几种常见的循环场景，循环过程中会发生什么：
**考虑点：1）能否正常退出循环，2）循环外是否能确定目标元素**
1. low <= high
    1. 存在赋值语句 `high = mid;`，那么 low = mid 情况下，无法退出循环。比如 [1, 2] 或者 [1], target = 0，均无法退出循环，所以**不要允许这种情况存在**。
    2. 存在赋值语句 `high = mid - 1;`，那么循环结束后可能存在 high < low 场景，如果 low = 0，那么 high 作为数组下标会越界，所以**这种情况尽量在循环内部找到 target 并返回，在循环结束后不对数组做访问**。代码示例见 Solution#search1
2. low < high
    1. 存在赋值语句 `high = mid;`，那么 low = mid 情况下，无法退出循环。比如 [1, 2], target = 0，无法退出循环，所以**不要允许这种情况存在**。
    2. 存在赋值语句 `high = mid - 1;`，那么循环结束后可能存在 high < low 场景，如果 low = 0，那么 high 作为数组下标会越界，所以**这种情况尽量在循环内部找到 target 并返回，在循环结束后只对 nums[low] 与 target 作比较**。代码示例见 Solution#search3
3. low + 1 < high
    1. 存在赋值语句 `high = mid;`，可以退出循环，且循环外部可能存在 low + 1 = high 以及 low = high 这两种场景，所以**这种情况可以不在循环内部找到 target，统一在循环结束后对 nums[low] 和 nums[high] 与 target 作比较**。代码示例见 Solution#search2
    2. 存在赋值语句 `high = mid - 1;`，可以退出循环，循环外部可能存在的情况是 1）奇数个元素退出循环如 [1, 2, 3]，high = low；2）偶数个元素退出循环如 [1, 2, 3, 4]，high = low，3）单个元素不进入循环如 [1]，high = low，4）两个元素不进入循环如 [1, 2]，所以**这种情况与 high = mid 相似，看个人喜好，不再进行代码示例**

综上：
1. low <= high 时，循环内部一定要使用 `high = mid - 1;`，并且依靠 nums[mid] 与 target 比较、在循环内部确定返回值；
2. low + 1 < high 时，循环内部可以使用 `high = mid` 或者 `high = mid - 1`，循环内部确定范围，在循环外部、依靠 nums[low] 和 nums[high] 与 target 的比较确定返回值
3. low < high，与 `high = mid - 1;` 搭配使用，不建议该方式实现


