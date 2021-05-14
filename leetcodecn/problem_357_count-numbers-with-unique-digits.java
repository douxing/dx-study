class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int base = 9;
        int bitCount = 1;
        int ans = 10;
        
        while (bitCount < n && bitCount < 11) {
            bitCount += 1;
            base = base * (11 - bitCount);
            ans += base;
        }

        return ans;
    }
}

