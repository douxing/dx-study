class Solution {

    void printdp(int[] dp) {
	System.out.print("[");
	for (int i = 0; i < dp.length; i += 1) {
	    if (i == dp.length - 1) {
		System.out.print("" + dp[i]);
	    } else {
		System.out.print("" + dp[i] + ", ");
	    }
	}
	System.out.println("]");	
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = s.charAt(0) == s.charAt(len - 1) ? 1 : 0;
        for (int i = 1; i < len; i += 1) {
            dp[i] = dp[i - 1] == 1 || s.charAt(0) == s.charAt(len - 1 - i) ? 1 : 0;
        }

        int[] pre = new int[len];

        for (int i = 1; i < len; i += 1) {
            int[] t = pre;
            pre = dp;
            dp = t;
            dp[0] = pre[0] == 1 || s.charAt(i) == s.charAt(len - 1) ? 1 : 0;
            for (int j = len - 2; j >= 0; j -= 1) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[len - 1 - j] = pre[len - 2 - j] + 1;
                } else {
                    dp[len - 1 - j] = Math.max(dp[len - 2 - j], pre[len - 1 - j]);
                }
            }

        // printdp(dp);

        }

        // printdp(dp);

        return dp[len - 1];
    }
}
