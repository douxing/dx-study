class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i += 1) {
            dp = Math.max(dp, 0) + nums[i];
            max = Math.max(max, dp);
        }

        return max;
    }
}
