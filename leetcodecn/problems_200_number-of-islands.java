class Solution {
    void dfs(char[][] grid, int x, int y) {
        if (0 <= x && x < grid.length
                && 0 <= y && y < grid[0].length) {
            if (grid[x][y] == '0') {
                return;
            }
            grid[x][y] = '0';
            
            dfs(grid, x - 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x + 1, y);
            dfs(grid, x, y + 1);
        }

        return;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[0].length; j += 1) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count += 1;
                } 
            }
        }

        return count;
    }
}
