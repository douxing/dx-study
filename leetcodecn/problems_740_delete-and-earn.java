class Solution {
    public int deleteAndEarn(int[] nums) {
int[] points = new int[10001];
int max = 0;
for (int num : nums) {
    points[num] += num;
    if (max < num) max = num;
}

int[] dp = new int[10001];
dp[1] = points[1];
for (int i = 2; i <= max; i += 1) {
    dp[i] = Math.max(points[i] + dp[i - 2], dp[i - 1]);
}

return dp[max];

    }
}
