import java.util.Arrays;

/*
 * @Author: Joker
 * @Date: 2020-05-31
 */ 
public class FindFirstAndLastPos {

    /**
     * 常规解法1，分别找到两种位置
     * 
     * 执行用时 0ms
     * 内存消耗 42.4MB
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = findFirstPos(nums, target);
        int last = findLastPos(nums, target);
        return new int[] {first, last};
    }

    private static int findFirstPos(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findLastPos(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1};
        System.out.println(Arrays.toString(searchRange(nums1, 1)));
        int[] nums2 = new int[] {1, 1};
        System.out.println(Arrays.toString(searchRange(nums2, 1)));
    }
}