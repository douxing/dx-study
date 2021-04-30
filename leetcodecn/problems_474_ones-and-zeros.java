class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int c0 = 0;
            int c1 = 0;

            for (char ch : s.toCharArray()) {
                if (ch == '0') c0 += 1;
                else c1 += 1;
            }

            for (int i = m; i >= c0; i -= 1) {
                for (int j = n; j >= c1; j -= 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - c0][j - c1] + 1);
                }
            }

        }

        return dp[m][n];

    }
}
