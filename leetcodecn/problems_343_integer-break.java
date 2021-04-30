class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i += 1) {
            for (int j = 2; j <= i / 2; j += 1) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
