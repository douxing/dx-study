class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) { return 0; }
        if (len == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }

        // len >= 2;
        int prepre = 0, pre = 1, cur = 0;
        char prech = s.charAt(0);
        char ch = s.charAt(1);
        if (prech == '0') {
            return 0;
        } else if (prech == '1') {
            cur = ch == '0' ? 1 : 2;
        } else if (prech == '2') {
            cur = '1' <= ch && ch <= '6'  ? 2 : 1;
        } else {
            if (ch == '0') {
                return 0;
            } else {
                cur = 1;
            }
        }

        for (int i = 2; i < len; i += 1) {
            prepre = pre;
            pre = cur;
            prech = s.charAt(i - 1);
            ch = s.charAt(i);
            if (prech == '0') {
                if (ch == '0') {
                    cur = 0;
                } else {
                    cur = pre;
                }
            } else if (prech == '1') {
                if (ch == '0') {
                    cur = prepre;
                } else {
                    cur = pre + prepre;
                }
            } else if (prech == '2') {
                if (ch == '0') {
                    cur = prepre;
                } else if ('1' <= ch && ch <= '6') {
                    cur = pre + prepre;
                } else { // 7 8 9
                    cur = pre;
                }
            } else { // prech = 3~9
                if (ch == '0') {
                    cur = 0;
                } else {
                    cur = pre;
                }
            }
            if (cur == 0) {
                return 0;
            }
        }

        return cur;
    }
}
