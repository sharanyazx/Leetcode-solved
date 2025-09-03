// Last updated: 9/3/2025, 10:46:06 AM
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxDiff = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums[i] - nums[(i + 1) % n]); 
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}