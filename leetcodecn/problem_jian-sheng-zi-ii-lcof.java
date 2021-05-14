class Solution {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        int sum = 3;
        n -= 3;
        while (n > 4) {
            int t = (sum + sum) % 1000000007;
            sum = (t + sum) % 1000000007;
            n -= 3;
        }
        int t = sum;
        while (--n != 0) {
            t = (t + sum)% 1000000007;
        }
        return t;
    }
}
