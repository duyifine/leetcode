package airbnb;

import java.util.HashMap;

public class CollatzConjecture {
  
  public int findSteps(int num) {
    if (num == 1) return 0;
    
    if (num % 2 == 0) {
      return findSteps(num / 2) + 1;
    } else {
      return findSteps(3 * num + 1) + 1;
    }
  }
  
  public int findLongestSteps(int range) {
    if (range < 1) return 0;
    
    int result = 0;
    for (int i = 1; i <= range; i++) {
      int steps = findSteps(i);
      result = Math.max(result, steps);
    }
    
    return result;
  }
  
  HashMap<Integer, Integer> memo = new HashMap<>();
  private int findStepsII(int num) {
    if (num == 1) return 0;
    if (memo.containsKey(num)) {
      return memo.get(num);
    }
    
    if (num % 2 == 0) {
      num = num / 2;
    } else {
      num = num * 3 + 1;
    }
    int steps = findStepsII(num);
    memo.put(num, steps);
    return steps + 1;
  }
  
  public int findLongestStepsII(int range) {
    if (range < 1) return 0;
    
    int result = 0;
    for (int i = 1; i <= range; i++) {
      int steps = findStepsII(i);
      result = Math.max(result, steps);
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    CollatzConjecture sol = new CollatzConjecture();
    System.out.println(sol.findSteps(7));
    System.out.println(sol.findStepsII(1));
    System.out.println(sol.findStepsII(2));
    System.out.println(sol.findStepsII(3));
    System.out.println(sol.findStepsII(4));
    System.out.println(sol.findStepsII(5));
    System.out.println(sol.findStepsII(6));
    System.out.println(sol.findStepsII(7));
    System.out.println(sol.findStepsII(8));
    System.out.println(sol.findLongestStepsII(8));
  }
}