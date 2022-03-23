class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)
            return 0;
        int sellPrice = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            sellPrice = Math.min(sellPrice, prices[i]);
            profit = Math.max(profit, prices[i] - sellPrice);
        }
        
        return profit;
    }
}