
/*
 * @Author: Joker
 * @Date: 2020-05-31
 */ 
class SearchInRotatedSortedArray {

    /**
     * 常规解法，需要判断mid在哪一段上
     * 
     * 执行用时 0ms
     * 内存消耗 39.4MB
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
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
}