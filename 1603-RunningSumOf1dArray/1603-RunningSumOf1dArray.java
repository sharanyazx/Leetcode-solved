// Last updated: 9/3/2025, 10:47:34 AM
class Solution {
    public int[] runningSum(int[] nums) {
      for(int i=1;i<nums.length;i++){
        nums[i]+=nums[i-1];
      }
      return nums;  
    }
}