class Solution {

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int n : nums) {
            b = ~a & (b ^ n);
            a = ~b & (a ^ n);
        }
        return b;
    }


    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i += 1) {
            int c = 0;
            for (int n : nums) {
                c += (n >> i) & 1;
            }
            ans |= (c % 3) << i;
        }
        return ans;
    }
}
