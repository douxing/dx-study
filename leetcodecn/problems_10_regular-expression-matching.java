class Solution {
    boolean dfs(String s, int si, String p, int pi) {
	if (p.length() == pi) {
	    return s.length() == si;
	}
	// p.length() > pi;
	char pch = p.charAt(pi); // eat all non-kleene star string first
	while (pi + 1 < p.length() && p.charAt(pi + 1) != '*') {
	    if (si == s.length() || (pch != '.' && pch != s.charAt(si))) {
		return false;
	    }
	    si += 1;
	    pi += 1;
	    pch = p.charAt(pi);
	}

	if (pi + 1 == p.length()) { // maybe last char
	    return (si == s.length() - 1) && (pch == '.' || pch == s.charAt(si));
	}

	// pi + 1 < p.length() && charAt(pi + 1) == '*';
	// cond 1: not match then skip
	// cond 2: match and skip
	if (dfs(s, si, p, pi + 2)) {
	    return true;
	}

	while (si < s.length() && (pch == '.' || pch == s.charAt(si))) {
	    if (dfs(s, si + 1, p, pi + 2)) {
		return true;
	    }
	    si += 1;
	}

	if (si == s.length()) {
	    return false;
	}

	return dfs(s, si, p, pi + 2);
    }

    public boolean isMatch(String s, String p) {
	return dfs(s, 0, p, 0);
    }
}
