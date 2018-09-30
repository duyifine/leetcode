package array;

public class StockBuyingIII {
  
  public int maxProfit(int[] prices, int k) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
      return 0;
    }
    
    if (prices.length <= 2 * k) {
      return maxProfitWithoutLimit(prices);
    }
    
    int[] buy = new int[k + 1];
    int[] sell = new int[k + 1];
    for (int i = 0; i < k + 1; i++) {
      buy[i] = Integer.MIN_VALUE;
    }
    
    for (int i = 0; i < prices.length; i++) {
      for (int j = k; j > 0; j--) {
        sell[j] = Math.max(sell[j], buy[j] + prices[i]);
        buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
      }
    }
    return sell[k];
  }
  
  private int maxProfitWithoutLimit(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, maxProfit + prices[i] - prices[i - 1]);
    }
    return maxProfit;
  }
  
  public int maxProfitTwoTransactions(int[] prices) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
      return 0;
    }
    
    int buy1 = Integer.MIN_VALUE;
    int sell1 = 0;
    int buy2 = Integer.MIN_VALUE;
    int sell2 = 0;
    for (int i = 0; i < prices.length; i++) {
      buy1 = Math.max(buy1, -prices[i]);
      sell1 = Math.max(sell1, buy1 + prices[i]);
      buy2 = Math.max(buy2, sell1 - prices[i]);
      sell2 = Math.max(sell2, buy2 + prices[i]);
    }
    return sell2;
  }
}