// Last updated: 9/3/2025, 10:47:05 AM
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X=0;
        for(String i: operations){
            if(i.equals("X++") || i.equals("++X")){
                X++;
            }
            else if(i.equals("X--") || i.equals("--X")){
                X--;
            }
        }
        
        return X;

    }
}