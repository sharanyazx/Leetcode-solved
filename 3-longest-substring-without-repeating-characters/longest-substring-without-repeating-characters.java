class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n=128;
        int[] arr = new int[n];
        for(int i=0,j=0;j<s.length();j++){
            i = Math.max(arr[s.charAt(j)],i);
            maxLen = Math.max(maxLen,-i+1+j);
            arr[s.charAt(j)] = j+1;
        }
        return maxLen;
    }
}