class Solution {
    public int strStr(String haystack, String needle) {

        // if word length is less than substring length return -1
        if (haystack.length() < needle.length()) return -1;
        // traverse upto (word - substring) sadbutsad-sad=5->upto 5 index
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        
        return -1;        
    }
}