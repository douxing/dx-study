class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        double[][] pre = new double[n][n];
        dp[row][column] = 1.0;

        while (k-- > 0) {
            double[][] t = pre;
            pre = dp;
            dp = t;

            Arrays.fill(dp[0], 0);
            if (n > 1) {
            Arrays.fill(dp[1], 0);
            }

            for (int i = 0; i < n; i += 1) {
                if (i + 2 < n) {
                    Arrays.fill(dp[i + 2], 0);
                }

                for (int j = 0; j < n; j += 1) {
                    double v = pre[i][j] / 8;

                    if (i - 1 >= 0 && j - 2 >= 0) dp[i - 1][j - 2] += v;
                    if (i + 1 < n && j + 2 < n) dp[i + 1][j + 2] += v;
                    if (i - 1 >= 0 && j + 2 < n) dp[i - 1][j + 2] += v;
                    if (i + 1 < n && j - 2 >= 0) dp[i + 1][j - 2] += v;

                    if (i - 2 >= 0 && j - 1 >= 0) dp[i - 2][j - 1] += v;
                    if (i + 2 < n && j + 1 < n) dp[i + 2][j + 1] += v;
                    if (i - 2 >= 0 && j + 1 < n) dp[i - 2][j + 1] += v;
                    if (i + 2 < n && j - 1 >= 0) dp[i + 2][j - 1] += v;
                }
            }
        }

        double v = 0.0;
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n; j += 1) {
                v += dp[i][j];
                //System.out.print(" " + dp[i][j]);
            }
            //System.out.println("");
        }

        return v;
    }
}
