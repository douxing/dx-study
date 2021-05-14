class Solution {
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int[] ans = new int[len + 1];

        int a = 0;
        for (int i = 1; i < len; i += 2) {
            a = a ^ encoded[i];
        }
        int b = 0;
        for (int i = 1; i <= len + 1; i += 1) {
            b = b ^ i;
        }
        ans[0] = a ^ b;
        //System.out.println("a[0]: " + ans[0] + a + b);

        for (int i = 1; i < len + 1; i += 1) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }

        return ans;
    }
}
