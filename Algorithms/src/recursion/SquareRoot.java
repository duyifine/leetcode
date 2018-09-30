package recursion;

public class SquareRoot {
  
  public int sqrt(int n) {
    if (n < 0) return -1;
    if (n == 0) return 0;
    if (n == 1) return 1;
    
    int left = 1;
    int right = n;
    int result = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid * mid == n) {
        return mid;
      } else if (mid * mid > n) {
        right = mid - 1;
      } else {
        if ((mid + 1) * (mid + 1) > n) {
          result = mid;
        }
        left = mid + 1;
      }
    }
    
    return result;
  }
}