class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i += 1) {
            dp[i] = dp[i - 1] + 1; // initial value i = (i - 1) + 1 * 1
            int b = 1;
            while (b * b <= i) {
                dp[i] = Math.min(dp[i], dp[i - b * b] + 1);
                b += 1;
            }
        }
        return dp[n];
    }
}
