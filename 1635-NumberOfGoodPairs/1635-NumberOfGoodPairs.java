// Last updated: 9/3/2025, 10:47:35 AM
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int good=0;
        for(int i =0;i<nums.length-1;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]==nums[j]) good++;
            }
        }
        return good;
    }
}