class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findPosition(nums, target, true);
        int last = findPosition(nums, target, false);
        return new int[]{first, last};
    }

    private int findPosition(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                position = mid; 
                if (findFirst) {
                    right = mid - 1; 
                } else {
                    left = mid + 1;              }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return position;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println(Arrays.toString(solution.searchRange(nums1, target1)));  
    }
}
