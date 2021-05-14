class Solution {
    public int maximalSquare(char[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;

        int max = 0;
        int[] dp = new int[clen];
        for (int i = 0; i < clen; i += 1) {
            dp[i] = matrix[0][i] - '0';
            max = Math.max(max, dp[i]);
        }
        for (int i = 1; i < rlen; i += 1) {
            for (int j = clen - 1; j > 0; j -= 1) {
                int side = 0;
                for (int k = 1; k <= dp[j - 1]; k += 1) {
                    if (matrix[i][j - k] == '1' && matrix[i - k][j] == '1') {
                        side += 1;
                    } else {
                        break;
                    }
                }

                if (matrix[i][j] == '1') {
                    dp[j] = side + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
            dp[0] = matrix[i][0] - '0';
            max = Math.max(max, dp[0]);
        }

        return max * max;
    }
}
