// class Solution 
// {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) 
//     {
//         int m = nums1.length, n = nums2.length;
//         int[] nums = new int[m+n];
//         int i = 0, j = 0, ind = 0;

//         while(i < m || j < n)
//         {
//             if(i >= m) 
//             {
//                 nums[ind++] = nums2[j++];
//                 continue;
//             }
//             else if(j >= n) 
//             {
//                 nums[ind++] = nums1[i++];
//                 continue;
//             }
//             else if(i < m && j < n && nums1[i] < nums2[j])
//             {
//                 nums[ind++] = nums1[i];
//                 i++;
//             }
//             else
//             {
//                 nums[ind++] = nums2[j];
//                 j++;
//             }
//         }
//         int mid = (m+n)/2;
//         if((m+n) % 2 == 0)
//         {
//             return (double)(nums[mid] + nums[mid-1])/2;
//         }
//         return (double)nums[mid];
//     }
// }
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Create a new array to hold merged values
        int[] merged = new int[m + n];
        
        // Copy nums1 and nums2 into merged
        System.arraycopy(nums1, 0, merged, 0, m);
        System.arraycopy(nums2, 0, merged, m, n);
        
        // Sort the merged array
        Arrays.sort(merged);
        
        // Find the median
        int total = m + n;
        if (total % 2 == 0) {
            return (merged[total/2 - 1] + merged[total/2]) / 2.0;
        } else {
            return merged[total/2];
        }
    }
}
