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



    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i += 1) {
            dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
        }

        printdp(dp);

        return Math.min(dp[len - 2], dp[len - 1]);
    }
}
