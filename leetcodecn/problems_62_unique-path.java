class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i += 1) {
            for (int j = 1; j < n; j += 1) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
}
