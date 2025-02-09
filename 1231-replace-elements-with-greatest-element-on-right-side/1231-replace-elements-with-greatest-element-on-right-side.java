class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int last = -1; // Last element is always replaced with -1
        for (int i = n - 1; i >= 0; i--) { // Traverse from right to left
            int temp = arr[i]; // Store current element
            arr[i] = last; // Replace with maxRight
            last= Math.max(last, temp); // Update maxRight
        }

        return arr;
    }
}
