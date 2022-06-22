class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)
            return 0;
        int maxProfit = 0;
        int buyPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            buyPrice = Math.min(buyPrice, prices[i]);
        }
        
        return maxProfit;
    }
}