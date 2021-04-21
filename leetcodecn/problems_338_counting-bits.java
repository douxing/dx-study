class Solution {
    // https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
    public int[] countBits(int num) {
        int[] a = new int[num + 1];
        a[0] = 0;
        if (num == 0) { return a; }
        a[1] = 1;
        if (num == 1) { return a; }
        for (int i = 2; i <= num; i += 1) {
            a[i] = a[i>>1] + (i&1);
        }
        return a;
    }
}
