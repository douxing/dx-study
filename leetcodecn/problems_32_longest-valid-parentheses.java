    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return 0;
        }
        int[] dp = new int[len];
        int max = 0;
	if (s.charAt(0) == '(' && s.charAt(1) == ')') {
	    dp[1] = 2;
	    max = 2;
	}

        for (int i = 2; i < len; i += 1) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
		    dp[i] = dp[i - 2] + 2;
                } else { // s.charAt(i - 1) == ')'
		    int l = i - dp[i - 1] - 1;
		    if (l < 0) {
			dp[i] = 0;
		    } else if (l == 0) {
			if (s.charAt(l) == '(') {
			    dp[i] = dp[i - 1] + 2;
			} else {
			    dp[i] = 0;
			}
		    } else {// l > 0
			// System.out.println("l:" + l + "  dp[l-1]:" + dp[l-1]);
			if (s.charAt(l) == '(') {
			    dp[i] = dp[i - 1] + dp[l - 1] + 2;
			} else {
			    dp[i] = 0;
			}
		    }
                }
            }
	    max = Math.max(max, dp[i]);
        }

	return max;
    }

