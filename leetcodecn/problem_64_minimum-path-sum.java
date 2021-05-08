class Solution {
    public int minPathSum(int[][] grid) {
        int rlen = grid.length;
        int clen = grid[0].length;
        int[] dp = new int[clen];
        dp[0] = grid[0][0];
        for (int i = 1; i < clen; i += 1) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < rlen; i += 1) {
            dp[0] += grid[i][0];
            for (int j = 1; j < clen; j += 1) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[clen - 1];
    }
}
