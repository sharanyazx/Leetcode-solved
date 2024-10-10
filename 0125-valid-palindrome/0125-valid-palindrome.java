class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        StringBuilder sb= new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
        
    }
}