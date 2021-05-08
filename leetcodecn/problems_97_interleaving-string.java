class Solution {
    void printdp(boolean[] dp) {
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


    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        boolean[] row = dp[0];
        row[0] = true;
        for (int i = 0; i < len2; i += 1) {
            if (s2.charAt(i) != s3.charAt(i)) {
                break;
            } else {
                row[i + 1] = true;
            }
        }

        printdp(row);

        for (int i = 1; i <= len1; i += 1) {
            row = dp[i];
            row[0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= len2; j += 1) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } 
                 if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }

            printdp(row);
        }

        return dp[len1][len2];
    }
}
