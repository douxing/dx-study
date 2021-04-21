class Solution {
    int dp(int[] nums, int left, int right) {
	int pre = 0; // cur - 1
	int cur = 0; // 
	int tmp = 0;
	for (int i = left; i < right;, i += 1) {
	    tmp = cur;
	    cur = Math.max(pre + nums[i], tmp);
	    pre = tmp;
	}

	return cur;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
	}

        return Math.max(dp(nums, 0, nums.length - 1),
			dp(nums, 1, nums.length));
    }
}
