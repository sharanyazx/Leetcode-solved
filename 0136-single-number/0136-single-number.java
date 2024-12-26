
class Solution {
    public int singleNumber(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            count^=nums[i];
        }
        return count;
    }
}