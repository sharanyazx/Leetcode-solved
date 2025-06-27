class Solution{
   public int numSquares(int n) {
        int countDp[] = new int[n + 1];
        Arrays.fill(countDp, Integer.MAX_VALUE);
        countDp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                countDp[i] = Math.min(countDp[i], countDp[i - j * j] + 1);
            }
        }

        return countDp[n];
    }
}
