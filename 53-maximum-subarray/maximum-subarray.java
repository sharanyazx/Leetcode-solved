class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
           // if(nums[i]>max){
                 sum+=nums[i];
                if(sum>max){
                    max=sum;
                }
                if(0>sum){
                    sum=0;
                }
           // }


        }
        return max;
    }
}