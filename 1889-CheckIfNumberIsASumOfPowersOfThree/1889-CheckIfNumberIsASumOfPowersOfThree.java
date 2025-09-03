// Last updated: 9/3/2025, 10:47:19 AM
class Solution {
    public boolean checkPowersOfThree(int n) {
        // int rem=n%3;
        while(n>0){
            int rem=n%3;
        if(rem==2) return false;
        n=n/3;
        }
        return true;

    }
}