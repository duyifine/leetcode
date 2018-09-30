package dynamicProgramming;

public class WinnerPredict {
  public boolean PredictTheWinner(int[] nums) {
    if (nums == null || nums.length == 0) {
        return true;
    }
    
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
        total = total + nums[i];
    }
    
    int[][] dp = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
        dp[i][i] = nums[i];
        if (i + 1 < nums.length) {
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
    }
    
    for (int i = 2; i < nums.length; i++) {
        int j = 0;
        while (i + j < nums.length) {
            dp[j][i + j] = Math.max(nums[j] + Math.min(dp[j + 2][i + j], dp[j + 1][i + j - 1]), 
                                    nums[i + j] + Math.min(dp[j][i + j - 2], dp[j + 1][i + j - 1]));
            j++;
        }
    }
    
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
      }
    }
    
    System.out.println("total is: " + total);
    System.out.println("score of player1: " + dp[0][nums.length - 1]);
    if (total % 2 == 0) {
        if (dp[0][nums.length - 1] >= total / 2) {
            return true;
        }
    } else {
        if (dp[0][nums.length - 1] >= (total + 1) / 2) {
            return true;
        }
    }
    return false;
  }
  
  public static void main(String[] args) {
    WinnerPredict w = new WinnerPredict();
    int[] nums = {1, 1, 567, 1, 1, 99};
    System.out.println(w.PredictTheWinner(nums));
  }
}