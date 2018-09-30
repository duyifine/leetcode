package dynamicProgramming;

public class CoinChange {
  
  public  int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount == 0) return 0;
    
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    
    for (int i = 1; i <= amount; i++) {
      for (int c : coins) {
        dp[i] = Math.min(dp[i], dp[i - c] + 1);
      }
    }
    
    if (dp[amount] == Integer.MAX_VALUE) return -1;
    return dp[amount];
  }
  
  public int change(int amount, int[] coins) {
    if (coins == null || coins.length == 0) return 0;
    if (amount == 0) return 1;
    
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int c : coins) {
      for (int j = 1; j <= amount; j++) {
        if (j - c >= 0) {
          dp[j] = dp[j] + dp[j - c];
        }
      }
    }
    
    return dp[amount];
  }
}