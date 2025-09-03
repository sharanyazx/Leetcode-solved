// Last updated: 9/3/2025, 10:47:26 AM
class Solution {
    public boolean fun(int[] arr, boolean[] vis, int ind, int n) {
        if (ind == arr.length) {
            return true;
        }
        if (arr[ind] != 0) {
            return fun(arr, vis, ind + 1, n);
        }
        for (int i = n; i >= 1; i--) {
            if (vis[i]) {
                continue;
            }
            int nextInd = (i == 1) ? ind : ind + i;
            if (nextInd >= arr.length || arr[nextInd] != 0) {
                continue;
            }
            arr[ind] = i;
            arr[nextInd] = i;
            vis[i] = true;
            if (fun(arr, vis, ind + 1, n)) {
                return true;
            }
            arr[ind] = 0;
            arr[nextInd] = 0;
            vis[i] = false;
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int l = 2 * n - 1;
        int[] arr = new int[l];
        boolean[] vis = new boolean[n + 1];
        fun(arr, vis, 0, n);
        return arr;
    }
}