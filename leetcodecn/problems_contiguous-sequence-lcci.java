class Solution {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(max, dp);
        }

        return max;
    }
}
