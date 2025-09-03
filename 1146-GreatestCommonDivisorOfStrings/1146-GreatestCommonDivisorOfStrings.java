// Last updated: 9/3/2025, 10:48:17 AM
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))  return "";
        int gcdlength=gcd(str1.length(),str2.length());
        return str1.substring(0,gcdlength);
    }

    private int gcd(int a,int b){
        return b==0 ? a:gcd(b,a%b);
    }    
        
        
        
    
}