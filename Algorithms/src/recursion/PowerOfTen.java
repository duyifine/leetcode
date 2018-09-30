package recursion;

public class PowerOfTen {
  
  public boolean isPowerOfTen(int n) {
    if (n <= 0) {
      return false;
    }
    
    while (n % 10 == 0) {
      n = n / 10;
    }
    if (n == 1) {
      return true;
    }
    return false;
  }
  
  public boolean isPowerOfTenRecursion(int n) {
    if (n == 1) {
      return true;
    }
    if (n <= 0) {
      return false;
    }
    
    if (n % 10 == 0) {
      return isPowerOfTenRecursion(n / 10);
    } else {
      return false;
    }
  }
  
  public static void main(String[] args) {
    PowerOfTen p = new PowerOfTen();
    System.out.println(p.isPowerOfTen(1));
    System.out.println(p.isPowerOfTen(10));
    System.out.println(p.isPowerOfTen(100));
    System.out.println(p.isPowerOfTen(101));
    System.out.println(p.isPowerOfTenRecursion(1));
    System.out.println(p.isPowerOfTenRecursion(10));
    System.out.println(p.isPowerOfTenRecursion(100));
    System.out.println(p.isPowerOfTenRecursion(101));
  }
}