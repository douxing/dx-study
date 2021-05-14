class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int min = prices[0];
        int max = 0;
        
        for (int i = 1; i < len; i += 1) {
            int p = prices[i];
            max = Math.max(max, p - min);
            min = Math.min(min, p);
        }

        return max;
    }
}
