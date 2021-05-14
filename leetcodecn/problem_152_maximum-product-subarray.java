class Solution {
public int maxProduct(int[] nums) {
    int len = nums.length;
    if (len == 1) return nums[0];

    int max = nums[0];
    int min = nums[0];
    int ans = max;

    for (int i = 1; i < len; i += 1) {
        int max1 = Math.max(nums[i] * max, nums[i] * min);
        max1 = Math.max(max1, nums[i]);
        int min1 = Math.min(nums[i] * max, nums[i] * min);
        min1 = Math.min(min1, nums[i]);

        max = max1;
        min = min1;
        ans = Math.max(ans, max);
    }

    return ans;
}

    public int maxProduct1(int[] nums) {
        int max = 0;
        int len = nums.length;
        int[] dp = new int[len];

        if (len == 1) {
            return nums[0];
        }

        for (int i = 0; i < len; i += 1) {
            dp[i] = nums[i];
            max = Math.max(max, dp[i]);
        }

        for (int span = 1; span < len; span += 1) {
            for (int i = 0; i + span < len; i += 1) {
                dp[i] = dp[i] * nums[i + span];
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
