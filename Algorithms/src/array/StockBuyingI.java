package array;

public class StockBuyingI {
  
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
      return 0;
    }
    
    int curMax = 0;
    int maxProfit = 0;
    for (int i = 1 ;i < prices.length; i++) {
      curMax = Math.max(0, curMax + prices[i] - prices[i - 1]);
      maxProfit = Math.max(maxProfit, curMax);
    }
    
    return maxProfit;
  }
  
  public int maxProfitII(int[] prices) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
      return 0;
    }
    
    int min = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      min = Math.min(prices[i], min);
      maxProfit = Math.max(prices[i] - min, maxProfit);
    }
    
    return maxProfit;
  }
  
  public static void main(String[] args) {
    int[] prices = {1,2,3,4,5,3,8,9,10};
    StockBuyingI s = new StockBuyingI();
    System.out.println(s.maxProfit(prices));
    System.out.println(s.maxProfitII(prices));
  }
}