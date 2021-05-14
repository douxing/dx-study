class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (query_row == 0)  {
           return (double)Math.min(1, poured);
        }
        int len = query_row + 1;
        double[] dp = new double[len];
        double[] pre = new double[len];
        dp[0] = (double)poured;

        int row = 1;
        while (row < query_row) {
            double[] t = pre;
            pre = dp;
            dp = t;
            Arrays.fill(dp, 0);
            if (pre[0] > 1) {
                dp[0] = (pre[0] - 1) / 2;
            }
            for (int j = 1; j <= row; j += 1) {
                if (pre[j - 1] > 1) {
                    dp[j] += (pre[j - 1] - 1) / 2;
                }
                if (pre[j] > 1) {
                    dp[j] += (pre[j] - 1) / 2; 
                }
            }
            if (pre[row - 1] > 1) {
                dp[row] = (pre[row - 1] - 1) / 2;
            }
            row += 1;
        }

        // assert row == query_row
        pre = dp;
        double val = 0.0;
        if (query_glass == 0 || query_glass == query_row) {
            val = pre[0] > 1 ? Math.min(1.0, (pre[0] - 1) / 2) : 0.0;
        } else {
            val += pre[query_glass - 1] > 1 ? (pre[query_glass - 1] - 1) / 2 : 0.0;
            val += pre[query_glass] > 1 ? (pre[query_glass] - 1) / 2 : 0.0;
        }

        return Math.min(1.0, val);
    }
}
