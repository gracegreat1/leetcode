/*
 * @Author: Joker
 * @Date: 2020-05-23 22:54:39
 * @FilePath: /leetcode/Solutions/BinarySearch/704_Solution/Solution.java
 */ 
public class Solution {
    /**
     * 普通二分查找
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
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 只有一个元素
        int[] nums1 = new int[] {1};
        System.out.println(search(nums1, 1));
        System.out.println("===============================");

        // 只有两个元素
        int[] nums2 = new int[] {1, 2};
        System.out.println(search(nums2, 1));
        System.out.println(search(nums2, 2));
        System.out.println("===============================");

        // 普通奇数数组
        int[] nums3 = new int[] {1, 2, 3, 3, 5};
        System.out.println(search(nums3, 5));
        System.out.println("===============================");
        
        // 普通偶数数组
        int[] nums4 = new int[] {2, 2, 3, 4};
        System.out.println(search(nums4, 2));
    }
}