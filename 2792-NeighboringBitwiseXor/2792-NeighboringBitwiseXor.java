// Last updated: 9/3/2025, 10:46:35 AM
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        for (int x : derived) {
            res ^= x;
        }
        return res == 0;
    }
}