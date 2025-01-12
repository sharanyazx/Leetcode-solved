class Solution {
    public int[] getConcatenation(int[] nums) {
        int len =nums.length;
        int []result=new int[len*2];
        for(int i=0;i<len;i++){
            result[i]=nums[i];
        }
        for(int i=0;i<len;i++){
            result[i + len]=nums[i];
        }
        return result;
        
    }
}