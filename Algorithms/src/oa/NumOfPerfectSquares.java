package oa;

public class NumOfPerfectSquares {
  
  public int perfectSquaresNum(int a, int b) {
    if (b <= 0) {
      return 0;
    }
    
    int start = 0;
    if (a >= 0) {
      start = (int) Math.sqrt(a);
    }
    int end = (int) Math.sqrt(b);
    
    return end - start + 1;
  }
  
  public static void main(String[] args) {
    NumOfPerfectSquares t = new NumOfPerfectSquares();
    System.out.println(t.perfectSquaresNum(-2, -1));
    System.out.println(t.perfectSquaresNum(-1, 4));
    System.out.println(t.perfectSquaresNum(4, 17));
  }
}