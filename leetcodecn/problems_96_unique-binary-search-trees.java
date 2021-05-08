class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i += 1) {
            int remain = i - 1;
            for (int left = 0; left <= remain / 2; left += 1) {
                int right = remain - left;
                int inc = dp[left] * dp[right];
                dp[i] += left == right ? inc : inc + inc;
            }
        }
        return dp[n];
    }
}
