
class Solution {
    public int reverse(int x) {
        double ans =  0;
        while(x!=0) {
            double rem = x%10;
            ans = ans*10+rem;
            if(ans>=Integer.MAX_VALUE || ans<=Integer.MIN_VALUE ) 
                return 0;
            x =x/10;
        }
        return (int)ans;
    }
}