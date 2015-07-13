//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete at most two transactions.

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int profit = 0;
        int n = prices.length;
        
        //if transact twice
        int[] leftProfit = new int[n];
        int min = prices[0];
        leftProfit[0] = 0;
        for(int i = 1; i < n; i ++){
            min = Math.min(min, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i] - min);
        }
        
        int[] rightProfit = new int[n];
        //keep track of max price as the price to sell, iterate the buy price to cal profit
        int max = prices[n - 1];
        rightProfit[n - 1] = 0;
        for(int i = n - 2; i >= 0; i --){
            max = Math.max(max, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], max - prices[i]);
        }
        
        for(int i = 0; i < n; i++){
            profit = Math.max(profit, leftProfit[i] + rightProfit[i]);
        }
        
        return profit;
    }
};

