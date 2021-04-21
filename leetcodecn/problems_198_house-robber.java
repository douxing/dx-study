class Solution {

    int dp(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }
        
        int[] c = new int[len];
        c[0] = nums[0];
        c[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i += 1) {
            c[i] = Math.max(c[i - 2] + nums[i], c[i - 1]);
        }

        return c[len - 1];
    }
    public int rob(int[] nums) {
        return dp(nums);
    }
}
