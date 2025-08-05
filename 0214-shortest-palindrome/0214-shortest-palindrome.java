class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        
        // Find the longest palindromic prefix
        for (int i = 0; i < n; i++) {
            if (s.startsWith(rev.substring(i))) {
                // Add the remaining part in front
                return rev.substring(0, i) + s;
            }
        }
        
        return ""; // Should never reach here
    }
}
