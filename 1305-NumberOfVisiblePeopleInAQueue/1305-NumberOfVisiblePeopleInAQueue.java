// Last updated: 9/3/2025, 10:47:58 AM
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();  // Monotonic decreasing stack

        for (int i = n - 1; i >= 0; i--) {
            int visible = 0;

            // See all shorter people
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                visible++;
            }

            // Can see the next taller/equal person too (if exists)
            if (!stack.isEmpty()) {
                visible++;
            }

            res[i] = visible;
            stack.push(heights[i]);
        }

        return res;
    }
}
