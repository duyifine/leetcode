package array;

public class StockBuyingII {
  
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
      return 0;
    }
    
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit = maxProfit + prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }
}