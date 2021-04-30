class Solution {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        Set<Integer>[] dp = new HashSet[len];

        dp[0] = new HashSet();
        dp[0].add(1);
        for (int i = 1; i < len; i += 1) {
            dp[i] = new HashSet();
            for (int j = 0; j < i; j += 1) {
                int span = stones[i] - stones[j];
                if (dp[j].contains(span)) {
                    dp[i].add(span);
                    dp[i].add(span + 1);
                    if (span - 1 > 0) {
                        dp[i].add(span - 1);
                    }
                }
            }
        }

        return dp[len - 1].size() > 0;
    }
}

