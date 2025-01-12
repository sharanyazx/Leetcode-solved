class Solution {
    public int minimumOperations(int[] nums) {
       int oper=0;
        for(int num:nums){
            int rem=num%3;
            if(rem==1){
                oper+=1;
            }
            else if(rem==2){
                oper+=1;
            }
        }
     
        return oper;
    }
}