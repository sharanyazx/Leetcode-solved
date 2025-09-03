// Last updated: 9/3/2025, 10:47:37 AM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n]; 
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];      
            result[2 * i + 1] = nums[n + i];
        }
        return result; // Return the shuffled result array
    }
}
