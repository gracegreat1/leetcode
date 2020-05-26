/*
 * @Author: Joker
 * @Date: 2020-05-23 22:54:39
 * @FilePath: /leetcode/Solutions/BinarySearch/704_Solution/Solution.java
 */ 
public class Solution {
    /**
     * 普通二分查找
     * 
     * 执行用时 0ms
     * 内存消耗 40.5MB
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 另一种二分查找，侧重范围的定位
     * 将目标范围限制在两个位置（low/high）中
     * 
     * 执行用时 0ms
     * 内存消耗 41MB
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid;
            }
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            return high;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 只有一个元素
        int[] nums1 = new int[] {1};
        System.out.println(search(nums1, 1));
        System.out.println(search2(nums1, 1));
        System.out.println("===============================");

        // 只有两个元素
        int[] nums2 = new int[] {1, 2};
        System.out.println(search(nums2, 1));
        System.out.println(search2(nums2, 1));
        System.out.println("===============================");

        // 普通奇数数组
        int[] nums3 = new int[] {1, 2, 3, 4, 5};
        System.out.println(search(nums3, 5));
        System.out.println(search2(nums3, 5));
        System.out.println("===============================");
        
        // 普通偶数数组
        int[] nums4 = new int[] {1, 2, 3, 4};
        System.out.println(search(nums4, 2));
        System.out.println(search2(nums4, 2));
    }
}