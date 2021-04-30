class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int goal = sum / 2;
        if (goal * 2 != sum) {
            return false;
        }

        boolean[] dp = new boolean[goal + 1];
        for (int n : nums) {
            dp[0] = true;
            for (int i = goal; i > 0; i -= 1) {
                int index = i - n;
                if (index >= 0) {
                    dp[i] = dp[i] || dp[index];
                }
            }
        }
        
        return dp[goal];
    }
}
