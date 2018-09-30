package recursion;

public class NumberOfPowTwo {
  
  public int numPowTwo(int num) {
    if (num == 0 || num == 1 || num == 2) {
      return 1;
    }
    
    if (Integer.bitCount(num) == 1) {
      return 1;
    }
    
    int pow = 1;
    for (int i = 1; i < num; i++) {
      pow = pow * 2;
      if (pow > num) {
        break;
      }
    }
    return numPowTwo(pow - num) + 1;
  }
  
  public static void main(String[] args) {
    NumberOfPowTwo t = new NumberOfPowTwo();
    System.out.println(t.numPowTwo(7));
    System.out.println(t.numPowTwo(8));
  }
}