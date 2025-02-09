class Solution {
    public boolean validMountainArray(int[] arr) {
      int i = 0, n = arr.length;
      // Ascending part (Increasing)
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        // Peak should not be first or last element
        if (i == 0 || i == n - 1) return false;

        // Descending part (Decreasing)
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        // If we reach the end, it's a valid mountain
        return i == n - 1;
    }
}

 