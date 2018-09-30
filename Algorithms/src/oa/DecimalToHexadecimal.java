package oa;

public class DecimalToHexadecimal {
  
  char[] digits = {'O', 'I', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'
      ,'C', 'D', 'E', 'F'};
  public String transform(int num) {
    if (num < 0) {
      return "ERROR";
    }
    if (num == 0) {
      return "O";
    }
    
    String result = "";
    while (num > 0) {
      int digit = num % 16;
      if (digit >= 2 && digit <= 9) {
        return "ERROR";
      }
      result = digits[digit] + result;
      num = num / 16;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    DecimalToHexadecimal t = new DecimalToHexadecimal();
    System.out.println(t.transform(-1));
    System.out.println(t.transform(0));
    System.out.println(t.transform(16));
    System.out.println(t.transform(25));
    System.out.println(t.transform(Integer.MAX_VALUE));
    System.out.println(Long.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Long.parseLong("1000000000000"));
  }
}