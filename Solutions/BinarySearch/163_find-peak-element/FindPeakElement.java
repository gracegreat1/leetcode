/*
 * @Author: Joker
 * @Date: 2020-05-31
 */ 
class findPeakElement {
    /**
     * mid与mid+1的大小关系->变化趋势->极值在左侧还是右侧
     * 
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 趋势递减
                high = mid;
            } else {
                // 趋势递增
                low = mid;
            }
        }
        return nums[low] > nums[high] ? low : high;
    }

    public static void main(String[] args) {
        // 1个元素
        int[] nums1 = new int[] {1};
        System.out.println(findPeakElement(nums1));
        // 2个元素，递增
        int[] nums2 = new int[] {1, 2};
        System.out.println(findPeakElement(nums2));
        // 2个元素，递减
        int[] nums3 = new int[] {2, 1};
        System.out.println(findPeakElement(nums3));
        // 奇数个元素
        int[] nums4 = new int[] {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums4));
        // 偶数个元素
        int[] nums5 = new int[] {1, 2, 3, 1};
        System.out.println(findPeakElement(nums5));
    }
}