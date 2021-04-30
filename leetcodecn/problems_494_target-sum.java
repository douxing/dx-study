class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        for (int n : nums) {
            target += n;
        }

        int goal = target / 2;
        if (goal + goal != target) {
            return 0;
        }

        int[] dp = new int[goal + 1];
        dp[0] = 1;
        for (int n: nums) {
            for (int i = goal; i >= n; i -= 1) {
                dp[i] += dp[i - n];
            }
        }

        return dp[goal];
    }
}
