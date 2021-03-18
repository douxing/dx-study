class Solution {
    public int numDistinct(String s, String t) {
	if (s.length() < t.length()) {
	    return 0;
	}

	int[][] dp = new int[s.length() + 1][t.length() + 1];
	for (int i = 0; i < s.length() + 1; i += 1) {
	    dp[i][t.length()] = 1;
	}

	for (int i = s.length() - 1; i >= 0; i -= 1) {
	    for (int j = t.length() - 1; j >= 0; j -= 1) {
		if (s.charAt(i) == t.charAt(j)) {
		    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
		} else {
		    dp[i][j] = dp[i + 1][j];
		}
	    }
	}

	return dp[0][0];
    }
}

/*
class Solution {
    int dfs(String s, int si, String t, int ti) {
	if (ti == t.length()) {
	    return 1; // a match
	} else if (si == s.length()) {
	    return 0; // a mismatch
	} else if (s.length() - si < t.length() - ti) {
	    return 0;
	} else if (s.length() - si == t.length() - ti) { // s.length() - si == t.length() - ti
	    while (si < s.length()) { // same length remaining
		if (s.charAt(si) != t.charAt(ti)) {
		    return 0;
		}
		si += 1;
		ti += 1;
	    }
	    return 1;
	}

	// ti < t.length() && si < s.length()

	int count = 0;
	char tch = t.charAt(ti);

	// a match, choice1: match , choice2: skip
	// a mismatch, only choice: skip
	count += dfs(s, si + 1, t, ti); // skip anyway
	if (tch == s.charAt(si)) {
	    count += dfs(s, si + 1, t, ti + 1);
	}

	return count;
    }

    public int numDistinct(String s, String t) {
	return dfs(s, 0, t, 0);
    }
}
*/
