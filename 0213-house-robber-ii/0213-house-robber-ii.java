class Solution {
    public int rob(int[] nums) {
        int size=nums.length;
        if(size==1)
            return nums[0];
        else if(size==2)
            return Math.max(nums[0],nums[1]);
        int res1 = maxCost(nums, 0, size-1);
        int res2 = maxCost(nums, 1, size-1);
        return Math.max(res1,res2);
    }

    int maxCost(int[] nums,int st, int size){
        // int end = st + size;
        int[] dpCost = new int[size];
        if(size == 1)
            return nums[st];
        dpCost[0] = nums[st];
        dpCost[1] = Math.max(nums[st],nums[st+1]);
        for(int i=2;i<size;i++){
            dpCost[i] = Math.max(dpCost[i-1],dpCost[i-2]+nums[i+st]);
        }
        return dpCost[size-1];
    }
}
