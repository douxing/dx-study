class Solution {
    public int minSteps(int n) {
        int ans = 0;
        int d = 2;
        while (n > 1) {
            while ((n / d) * d == n) {
                n = n / d;
                ans += d;
            }
            d += 1;
        }

        return ans;
    }
}
