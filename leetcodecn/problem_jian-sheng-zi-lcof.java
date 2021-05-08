class Solution {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        else if (n == 3) return 2;


        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 2; i <= n; i += 1) {
            int max = i;
            for (int j = 1; j <= i / 2; j += 1) {
                max = Math.max(max, dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
