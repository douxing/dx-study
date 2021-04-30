class Solution {
    public int maxProfit(int[] prices) {
        int min = 100000;
        int profit = 0;
        for (int p : prices) {
            min = Math.min(min, p);
            profit = Math.max(profit, p - min);
        }

        return profit;
    }
}
