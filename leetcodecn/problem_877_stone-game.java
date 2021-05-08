class Solution {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] total = new int[len][len];
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i += 1) {
            total[i][i] = piles[i];
            dp[i][i] = piles[i];
            for (int j = i + 1; j < len; j += 1) {
                total[i][j] = total[i][j - 1] + piles[j];
            }
        }
        
        for (int span = 1; span < len; span += 1) {
            for (int i = 0; i + span < len; i += 1) {
                int j = i + span;
                dp[i][j] = Math.max(piles[i] + total[i + 1][j] - dp[i + 1][j],
                                    piles[j] + total[i][j - 1] - dp[i][j - 1]);
            }
        }

        int alex = dp[len-1][len-1];
        return alex * 2 > dp[len-1][len-1];
    }
}
