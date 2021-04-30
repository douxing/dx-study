package lc;

import java.util.*;

class DivSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList();
        Arrays.sort(nums);

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int count = 1;
	
        int maxval = nums[0];
        for (int i = 1; i < len; i += 1) {
            for (int j = 0; j < i; j += 1) {
                if (0 == nums[i] % nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (count < dp[i]) {
                count = dp[i];
                maxval = nums[i];
            }
        }

        List<Integer> res = new ArrayList(count);
        for (int i = len - 1; i >= 0; i -= 1) {
            if (dp[i] == count && maxval % nums[i] == 0) {
                res.add(nums[i]);
                count -= 1;
                maxval = nums[i];
            }
        }

        return res;
    }
}
