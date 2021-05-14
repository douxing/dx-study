class Solution {

    //     void printdp(int[] dp) {
	// System.out.print("[");
	// for (int i = 0; i < dp.length; i += 1) {
	//     if (i == dp.length - 1) {
	// 	System.out.print("" + dp[i]);
	//     } else {
	// 	System.out.print("" + dp[i] + ", ");
	//     }
	// }
	// System.out.println("]");	
    // }

    public int numWays(int steps, int arrLen) {
        final int mod = 1000000007;
        if (arrLen == 1 || steps == 1) return 1;
        int[] dp = new int[arrLen];
        int[] pre = new int[arrLen];
        arrLen = Math.min(arrLen, steps / 2 + 1);

        dp[0] = 1;
        for (int i = 0; i < steps ; i += 1) {
            int[] t = pre;
            pre = dp;
            dp = t;

            dp[0] = (pre[0] + pre[1]) % mod;
            int j = 1;
            while (j < Math.min(i + 1, arrLen - 1)) {
                dp[j] = (pre[j - 1] + pre[j]) % mod;
                dp[j] = (dp[j] + pre[j + 1]) % mod;
                j += 1;
            }
            dp[j] = (pre[j - 1] + pre[j]) % mod;

            //printdp(dp);
        }

        return dp[0];
    }
}
