package string;

public class StringToInteger {
  
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    
    // get rid of all leading spaces
    int i = 0;
    while (str.charAt(i) == ' ') {
      i++;
    }
    // the str only contains white spaces
    if (i == str.length()) {
      return 0;
    }
    
    int sign = 1;
    if (str.charAt(i) == '-') {
      sign = -1;
      i++;
    } else if (str.charAt(i) == '+'){
      i++;
    }
    
    int num = 0;
    while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(i) > Integer.MAX_VALUE % 10 + '0')) {
        if (sign == 1) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
      num = num * 10 + str.charAt(i) - '0';
      i++;
    }
    
    // check invalid characters
    if (i < str.length()) {
      return 0;
    }
    
    return num * sign;
  }
  
  public static void main(String[] args) {
    String str = "  -134";
    StringToInteger s = new StringToInteger();
    System.out.println(s.myAtoi(str));
    System.out.println(String.valueOf(Integer.MAX_VALUE));
    System.out.println(Integer.MIN_VALUE);
  }
}