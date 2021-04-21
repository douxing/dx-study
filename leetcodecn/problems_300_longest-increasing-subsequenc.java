class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i += 1) {
            dp[i] = 1;
            for (int j = 0; j < i; j += 1) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

