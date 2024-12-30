class Solution {
    public String reverseVowels(String s) {
        if(s==null ) return s;
        char[] c =s.toCharArray();
        int start = 0;
        int end =c.length-1;
        String vowels="aeiouAEIOU";
        while(start<end){
            while(start < end && vowels.indexOf(c[start])==-1){
                start++;
            }
            while(start < end && vowels.indexOf(c[end])==-1){
                end--;
            }
            char ch=c[start];
            c[start]=c[end];
            c[end]=ch;
            start++;
            end--;
        }
        
        return new String(c);
    }
}