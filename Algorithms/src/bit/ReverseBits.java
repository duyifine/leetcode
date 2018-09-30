package bit;

public class ReverseBits {
  
  public int reverse(int num) {
    int n = 4 * 8;
    for (int i = 0; i < n / 2; i++) {
      num = swapAPairOfBits(num, i, n - i - 1);
    }
    return num;
  }
  
  public int swapAPairOfBits(int x, int i, int j) {
    int right_bit = ((x >> i) & 1);
    int left_bit = ((x >> j) & 1);
    
    if ((right_bit ^ left_bit) == 1) {
      x = x ^ ((1 << i) | (1 << j));
    }
    return x;
  }
  
}