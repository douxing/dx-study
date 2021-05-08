class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;

        int t0 = 0;
        int t1 = 0;
        int t2 = 0;
        int t = 1;
        while (--n > 0) {
            t0 = t1;
            t1 = t2;
            t2 = t;
            t = t0 + t1 + t2;
        }

        return t;
    }
}
