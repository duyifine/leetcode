package recursion;

public class Power {
  
  public int a_pow_b(int a, int b) {
    if (b == 0) {
      return 1;
    }
    if (b == 1) {
      return a;
    }
    
    if (b % 2 == 0) {
      return a_pow_b(a, b / 2) * a_pow_b(a, b / 2);
    } else {
      return a_pow_b(a, b / 2) * a_pow_b(a, b / 2) * a;
    }
  }
}