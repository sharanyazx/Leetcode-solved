class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int[] len_dp = new int[n];
        Arrays.fill(len_dp, 1);

        int max = 1;

        for (int end = 1; end < n; end++) {
            for (int prev = 0; prev < end; prev++) {
                if (nums[end] > nums[prev]) {
                    len_dp[end] = Math.max(len_dp[end], len_dp[prev] + 1);
                }
            }
            max = Math.max(max, len_dp[end]);
        }

        return max;
    }
}
