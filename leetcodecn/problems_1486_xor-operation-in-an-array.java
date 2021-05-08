class Solution {
    public int xorOperation(int n, int start) {
        int res = start;
        while(--n > 0) {
            start += 2;
            res = res ^ start;
        }

        return res;
    }
}
