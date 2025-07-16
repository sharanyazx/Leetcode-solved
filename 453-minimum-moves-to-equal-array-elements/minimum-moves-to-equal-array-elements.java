class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int num:nums) {
             if(min>num) min=Math.min(min,num);
        }
       
        int move=0;

        for(int num:nums) move+=num-min;
        return move;
    }
}