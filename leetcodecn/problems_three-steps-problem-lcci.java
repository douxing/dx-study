class Solution {
    public int waysToStep(int n) {
        int mod = 1000000007;
        if (n == 1 || n == 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }

        int pre3 = 0;
        int pre2 = 1;
        int pre1 = 2;
        int cur = 4; // step == 3;
        int step = 4;
        while (step <= n) {
            pre3 = pre2;
            pre2 = pre1;
            pre1 = cur;

            cur = (pre1 + pre2) % mod;
            cur = (cur + pre3) % mod;

            step += 1;
        }

        return cur;
    }
}
