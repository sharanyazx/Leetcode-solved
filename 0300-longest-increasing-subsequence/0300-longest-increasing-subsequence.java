import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int[] len_dp = new int[n];
        int[] seq = new int[n];
        Arrays.fill(len_dp, 1);
        Arrays.fill(seq, -1);

        int max = 1;
        int lastIndex = 0;

        for (int end = 1; end < n; end++) {
            for (int prev = 0; prev < end; prev++) {
                if (nums[end] > nums[prev] && len_dp[prev] + 1 > len_dp[end]) {
                    len_dp[end] = len_dp[prev] + 1;
                    seq[end] = prev;
                }
            }

            if (len_dp[end] > max) {
                max = len_dp[end];
                lastIndex = end;
            }
        }

        // Optional: Reconstruct and print the LIS
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(nums[lastIndex]);
            lastIndex = seq[lastIndex];
        }
        Collections.reverse(lis);
        System.out.println("LIS Sequence: " + lis);

        return max;
    }
}
