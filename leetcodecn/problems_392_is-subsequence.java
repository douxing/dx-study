class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        } else if (t.length() == 0) {
            return false;
        }
        int sindex = 0;
        int tindex = 0;
        while (true) {
            if (s.charAt(sindex) == t.charAt(tindex)) {
                sindex += 1;
                tindex += 1;
            } else {
                tindex += 1;
            }

            if (sindex == s.length()) {
                return true;
            } else if (tindex == t.length()) {
                break;
            }
        }

        return false;
    }
}
