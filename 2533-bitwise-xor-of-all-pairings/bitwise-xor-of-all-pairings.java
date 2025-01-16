class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int a=0;
        int b=0;
        for(int i: nums1){
            a^=i;
        }
        for(int j:nums2){
           b^=j;
        }
        if(nums1.length%2 !=0 && nums2.length%2!=0){
            return a^b;
        }
        if(nums1.length%2 !=0) return b;
        if(nums2.length%2 !=0) return a;
        else return 0;
    }
}