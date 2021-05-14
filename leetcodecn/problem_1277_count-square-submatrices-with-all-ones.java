class Solution {
    public int countSquares(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;

        int sum = 0;
        int[] dp = new int[clen];
        int[] pre = new int[clen];
        for (int i = 0; i < clen; i += 1) {
            pre[i] = matrix[0][i];
            sum += matrix[0][i];
        }

        for (int i = 1; i < rlen; i += 1) {
            dp[0] = matrix[i][0];
            sum += matrix[i][0];
            for (int j = 1; j < clen; j += 1) {
                if (matrix[i][j] == 0) {
                    dp[j] = 0;
                } else {
                    dp[j] = 1 + Math.min(pre[j - 1], Math.min(dp[j - 1], pre[j]));
                    sum += dp[j];
                }
            }
            int[] t = pre;
            pre = dp;
            dp = t;
        }

        return sum;
    }
}
