class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0) return 0;

        int[][] vis = new int[m][n];

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col] == 1 && vis[row][col]==0){
                    int area = dfs(row, col, vis, grid, m, n);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

     int dfs(int row, int col, int[][] vis, int[][] grid, int m, int n){
        if(row<0 || col<0 || row>=m || col>=n){
            return 0;
        }
        int area = 0;
        if(vis[row][col]==0 && grid[row][col]==1){

            vis[row][col] = 1;
            area = 1;

            area += dfs(row+1, col, vis, grid, m, n);
            area += dfs(row-1, col, vis, grid, m, n);
            area += dfs(row, col+1, vis, grid, m, n);
            area += dfs(row, col-1, vis, grid, m, n);
        }

        return area;
    }
}