package oa;

public class VerticalPrint {
  
  public void printVertical(int i) {
    i = reverse(i);
    if (i < 0) {
      i = -i;
      System.out.println("-");
    }
    while (i != 0) {
      System.out.println(i % 10);
      i = i /10;
    }
  }
  
  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      rev = rev * 10 + x % 10;
      x = x / 10;
    }
    
    return rev;
  }
  
  public static void main(String[] args) {
    VerticalPrint s = new VerticalPrint();
    s.printVertical(12);
    s.printVertical(-214);
  }
}