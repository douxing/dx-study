class Solution {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] dec = new int[len + 1];
        dec[0] = first;
        for (int i = 0; i < len; i += 1) {
            dec[i + 1] = dec[i] ^ encoded[i]; 
        }
        return dec;
    }
}
