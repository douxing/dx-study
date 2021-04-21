package lc;

import java.util.*;

class LongestPalin {
    public String longestPalindrome(String s) {
	int maxi = 0;
	int maxj = 0;
	int len = s.length();
	boolean[][] m = new boolean[len][];
	for (int i = len - 1; i >= 0; i -= 1) {
	    m[i] = new boolean[len];
	    m[i][i] = true;
	    // System.out.println("i:" + i);
	    if (i + 1 < len) {
		// System.out.println("i + 1:" + i + 1);
		m[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		if (m[i][i + 1] && maxj - maxi < 1) {
		    maxi = i;
		    maxj = i + 1;
		}
	    }
	    for (int j = i + 2; j < len; j += 1) {
		m[i][j] = m[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
		if (m[i][j] && maxj - maxi < j - i) {
		    maxi = i;
		    maxj = j;
		}
	    }
	}

	// System.out.println(""+maxi+" "+ maxj);

	return s.substring(maxi, maxj + 1);
    }
}
