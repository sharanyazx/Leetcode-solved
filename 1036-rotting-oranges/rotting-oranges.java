import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // rotten orange
                } else if (grid[i][j] == 1) {
                    freshCount++; // fresh orange
                }
            }
        }

        if (freshCount == 0) return 0; // no fresh oranges to rot
        int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0} };

        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // rot the orange
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        rottedThisMinute = true;
                    }
                }
            }
            if (rottedThisMinute) {
                minutes++;
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
