class Solution {
    // dx: this should be wrong, but test case didn't get it
    // public int findLongestChain(int[][] pairs) {
    //     Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
    //     int len = pairs.length;
    //     int[] dp = new int[len];
    //     Arrays.fill(dp, 1);
    //     for (int i = 1; i < len; i += 1) {
    //         for (int j = 0; j < i; j += 1) {
    //             if (pairs[j][1] < pairs[i][0]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //     }

    //     return dp[len - 1];
    // }
    
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i += 1) {
            for (int j = 0; j < i; j += 1) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
