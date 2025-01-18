class Solution {

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, 0 });

        int[][] dist = new int[grid.length][grid[0].length];

        for (int[] it : dist) {
            Arrays.fill(it, Integer.MAX_VALUE);
        }

        while (!pq.isEmpty()) {
            int[] res = pq.poll();

            if (res[1] == grid.length - 1 && res[2] == grid[0].length - 1) {
                return res[0];
            }

            for (int i = 0; i < 4; i++) {
                int x = res[1] + dirs[i][0];
                int y = res[2] + dirs[i][1];

                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                    continue;
                }

                int cost = res[0] + (i + 1 == grid[res[1]][res[2]] ? 0 : 1);

                if (cost < dist[x][y]) {
                    dist[x][y] = cost;
                    pq.add(new int[] { cost, x, y });
                }
            }
        }

        return -1;
    }
}