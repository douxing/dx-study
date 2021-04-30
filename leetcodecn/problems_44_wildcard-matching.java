package lc;

import java.util.*;

public class WildMatch {
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

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
	boolean[] dp = new boolean[plen + 1];

	// match s == ""
	dp[0] = true;
	int i = 0;
	while (i < plen) {
	    if (p.charAt(i) != '*') {
		break;
	    }
	    dp[++i] = true;
	}
	while (i < plen) {
	    dp[++i] = false;
	}
	// end of match s == ""

	boolean[] dpPre = dp;
	printdp(dpPre);
	dp = new boolean[plen + 1];
	for (i = 0; i < slen; i += 1) {
	    dp[0] = false;
	    for (int j = 0; j < plen; j += 1) {
		char sch = s.charAt(i);
		char pch = p.charAt(j);
		
		if (pch == '?' || pch == sch) {
		    dp[j + 1] = dpPre[j];
		} else if (pch == '*') {
		    dp[j + 1] = dpPre[j] || dpPre[j + 1] || dp[j];
		} else {
		    dp[j + 1] = false;
		}
	    }

	    boolean[] t = dp;
	    dp = dpPre;
	    dpPre = t;
	    printdp(dpPre);
	}

	return dpPre[plen];
    }
}
