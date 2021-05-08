class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i += 1) {
            dp[i][i] = nums[i];
        }
        for (int span = 1; span < len; span += 1) {
            for (int i = 0; i + span < len; i += 1) {
                int j = i + span;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len-1] >= 0;
    }
}
