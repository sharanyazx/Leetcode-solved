// Last updated: 9/3/2025, 10:46:53 AM
import java.util.*;
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count =0;
        for(String word:words){
            if(word.startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}