// Last updated: 9/3/2025, 10:48:27 AM
import java.util.*;
class Solution {
    public int[] sortArray(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     for(int j=0;j<nums.length-1-i;j++){
        //         if(nums[j]>nums[j+1]){
        //             int temp=nums[j];
        //             nums[j]=nums[j+1];
        //             nums[j+1]=temp;
        //         }
        //     }
        // }
        // return nums;
       Arrays.sort(nums);
       return nums;
        
    }
}
