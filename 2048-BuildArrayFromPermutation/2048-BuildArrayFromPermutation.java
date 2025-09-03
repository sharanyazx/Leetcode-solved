// Last updated: 9/3/2025, 10:47:12 AM
class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int [] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=nums[nums[i]];
        }
        return result;
    }
}