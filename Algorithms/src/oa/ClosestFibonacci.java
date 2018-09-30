package oa;

public class ClosestFibonacci {
  
  public int fibonacci(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 0;
    }
    
    int a1 = 0;
    int a2 = 1;
    int result = 0;
    for (int i = 2; i <= n; i++) {
      result = a1 + a2;
      a1 = a2;
      a2 = result;
    }
    
    return result;
  }
  
  public int closestFibo(int target) {
    if (target == Integer.MIN_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (target <= 0) {
      return 0 - target;
    }
    if (target == 1) {
      return 0;
    }
    
    int a1 = 0;
    int a2 = 1;
    int k = target;
    int fibo = 0;
    while (k > 0) {
      fibo = a1 + a2;
      if (fibo >= target || fibo < 0) {
        break;
      }
      a1 = a2;
      a2 = fibo;
      k--;
    }
    
    if (fibo < 0) {
      return target - a2;
    }
    if (fibo == target) {
      return 0;
    } else {
      if (Math.abs(fibo - target) <= Math.abs(a2 - target)) {
        return Math.abs(fibo - target);
      }
      return Math.abs(a2 - target);
    }
  }
  
  public static void main(String[] args) {
    ClosestFibonacci t = new ClosestFibonacci();
    System.out.println(t.fibonacci(10));
    System.out.println(t.closestFibo(2));
    System.out.println(t.closestFibo(50));
    System.out.println(t.closestFibo(Integer.MAX_VALUE));
    System.out.println(t.closestFibo(Integer.MIN_VALUE));
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
  }
}