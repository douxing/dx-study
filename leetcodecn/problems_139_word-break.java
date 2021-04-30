package lc;

import java.util.*;

class SepStr {
    void pdp(boolean[] dp) {
	for (int i = 0; i < dp.length; i += 1) {
	    if (i == 0) {
		System.out.print("[" + dp[i]);
	    } else if (i == dp.length - 1) {
		System.out.println(", " + dp[i] + "]");
	    } else {
		System.out.print(", " + dp[i]);
	    }
	}
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i += 1) {
            for (int j = 0; j < wordDict.size(); j += 1) {
                String word = wordDict.get(j);
                int index = i - word.length();
                if (index >= 0) {
                    dp[i] = dp[i] || (dp[index] && word.equals(s.substring(index, i)));
                }
            }
        }

        return dp[len];
    }
}
