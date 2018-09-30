package recursion;

public class StairsClimb {
  
  public int climbStairs(int n) {
    if (n < 0) {
      return Integer.MIN_VALUE;
    }
    if (n == 0) {
      return 1;
    }
    
    int result = 0;
    for (int i = 1; i <= 3; i++) {
      int steps = climbStairs(n - i);
      if (steps > 0) {
        result = result + steps;
      }
    }
    
    return result;
  }
  
  public int climbStairsDP(int n) {
    if (n < 0) {
      return Integer.MIN_VALUE;
    }
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int[] steps = new int[n + 1];
    steps[0] = 0;
    steps[1] = 1;
    steps[2] = 2;
    steps[3] = 4;
    for (int i = 4; i < n + 1; i++) {
      steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
    }
    
    return steps[n];
  }
  
  public static void main(String[] args) {
    int n = 4;
    StairsClimb s = new StairsClimb();
    System.out.println(s.climbStairs(n));
    System.out.println(s.climbStairsDP(n));
  }
}