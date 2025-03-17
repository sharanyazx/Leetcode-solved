class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        Set <Float> set=new HashSet<>();
        while(l<=r){
            float avg= (float) (nums[l]+nums[r])/2f;
            set.add(avg);
            l++;
            r--;
        }
        return set.size();
    }
}