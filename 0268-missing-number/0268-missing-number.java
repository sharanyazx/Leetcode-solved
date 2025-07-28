class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length+1;
        int sum= n*(n-1)/2;
        for(int total:nums){
            sum=sum-total;
            
        }
        
        return sum;
        
    }
}