class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        int[] pre = new int[size];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i += 1) {
            List<Integer> line = triangle.get(i);
            int[] t = pre;
            pre = dp;
            dp = t; // swith dp and pre
            dp[0] = line.get(0) + pre[0];
            for (int j = 1; j < i; j += 1) {
                dp[j] = line.get(j) + Math.min(pre[j - 1], pre[j]);
            }
            dp[i] = line.get(i) + pre[i - 1];
        }

        int min = dp[0];
        for (int i = 1; i < size; i += 1) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
