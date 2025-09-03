// Last updated: 9/3/2025, 10:48:24 AM
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dpArray = new int[n + 1];
        dpArray[0] = 0;
        dpArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
        }

        return dpArray[n];
    }
}
