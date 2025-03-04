class Solution {
    public void rotate(int[] nums, int k) {

        LinkedList <Integer> a=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            a.add(nums[i]);
        }
        k = k % a.size();
        for(int i=0;i<k;i++) {
            a.addFirst(a.removeLast());
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a.removeFirst();
        }
    //     k=k%nums.length;
    //     reverse(nums,0,nums.length-1);
    //      reverse(nums,0,k-1);
    //       reverse(nums,k,nums.length-1);
    // }
    //     public void reverse(int []nums,int start,int end){
    //         while(start<end){
    //             int temp=nums[start];
    //             nums[start]=nums[end];
    //             nums[end]=temp;
    //             start++;
    //             end--;
    //         }
        }
        
    
}