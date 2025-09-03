// Last updated: 9/3/2025, 10:46:39 AM
class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        for(int i=n-1;i>0;--i){
            pref[i]^=pref[i-1];
        }
        return pref;
    }
}