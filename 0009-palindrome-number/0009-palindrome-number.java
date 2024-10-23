class Solution {
    public boolean isPalindrome(int x) {
        int sum=0,r;
        int temp=x;
        if(x<0){
            return false;
        }
        while(x!=0){
            r=x%10;
            sum=sum*10 + r;
            x=x/10;
        }
        return sum==temp;
    }
}