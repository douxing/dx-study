class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int j = 1; j <= len2; j += 1) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i += 1) {
            dp[i][0] = i;
            for (int j = 1; j <= len2; j += 1) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]); // delete
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]); // replace
                    dp[i][j] += 1;
                }
            }
        }

        return dp[len1][len2];
    }
}
