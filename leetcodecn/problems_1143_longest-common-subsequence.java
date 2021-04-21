package lc;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
	int len1 = text1.length();
	int len2 = text2.length();
	int[][] a = new int[len1 + 1][len2 + 1];

	for (int i = 1; i <= len1; i += 1) {
	    for (int j = 1; j <= len2; j += 1) {
		if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
		    a[i][j] = a[i - 1][j - 1] + 1;
		} else {
		    a[i][j] = java.lang.Math.max(a[i][j - 1], a[i - 1][j]);
		}
		System.out.println("["+i+"]["+j+"] = " + a[i][j]);
	    }
	}
 
	return a[len1][len2];
    }
}
