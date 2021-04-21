class Solution {
    // public boolean isPowerOfThree(int n) {
    //     return (n > 0 && 1162261467 % n == 0);
    // }

    public boolean isPowerOfThree(int n) {
        int i = 1;
        while (i <= n) {
            if (i == n) {
                return true;
            }
            i *= 3;
        }
        return false;
    }
}
