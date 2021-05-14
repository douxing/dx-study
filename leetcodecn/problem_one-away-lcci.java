class Solution {
    public boolean oneEditAway(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        
        int errc = 0;
        int i1 = 0;
        int i2 = 0;
        if (l1 > l2) {
            if (l1 - l2 > 1) {
                return false;
            }

            while (i2 < l2) {
                if (first.charAt(i1) != second.charAt(i2)) {
                    if (errc == 0) {
                        i1 += 1;
                        errc = 1;
                    } else { return false; }
                } else {
                    i1 += 1;
                    i2 += 1;
                }
            }
        } else if (l2 > l1) {
            if (l2 - l1 > 1) {
                return false;
            }

            while (i1 < l1) {
                if (first.charAt(i1) != second.charAt(i2)) {
                    if (errc == 0) {
                        i2 += 1;
                        errc = 1;
                    } else { return false; }
                } else {
                    i1 += 1;
                    i2 += 1;
                }
            }
        } else {
            for (int i = 0; i < l1; i += 1) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (errc != 0) {
                        return false;
                    }
                    errc += 1;
                }

                i1 += 1;
                i2 += 1;
            }
        }

        return true;
    }
}
