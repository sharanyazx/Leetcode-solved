// Last updated: 9/3/2025, 10:46:07 AM
class Solution {
    public boolean isBalanced(String num) {
        int ev=0,odd=0;
        for(int i=0;i<num.length();i++){
            if(i%2==0){
                ev+=num.charAt(i)-'0';
            }
            else odd+=num.charAt(i)-'0';
        }
        return ev==odd;
    }
}