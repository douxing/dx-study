package lc;

import java.util.*;

class ComSum {
    // int dfs(int[] nums, int target, int r) {
    // 	int count = 0;
    // 	for (int i = 0; i < nums.length; i += 1) {
    // 	    if (r + nums[i] < target) {
    // 		count += dfs(nums, target, r + nums[i]);
    // 	    } else if (r + nums[i] == target) {
    // 		count += 1;
    // 	    }
    // 	}
    // 	return count;
    // }
        
    public int combinationSum4(int[] nums, int target) {
	int dp[] = new int[target + 1];
	dp[0] = 1;
	for (int i = 1; i <= target; i += 1) {
	    for (int n : nums) {
		if (n <= i) {
		    dp[i] += dp[i - n];
		}
	    }
	}

	return dp[target];
    }
}
