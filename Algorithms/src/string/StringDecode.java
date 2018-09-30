package string;

public class StringDecode {
  
  public String decode(String input) {
    if (input == null || input.length() == 0 || input.length() == 1) {
      return input;
    }
    
    char[] array = input.toCharArray();
    int newLength = 0;
    int i = 1;
    while (i < input.length()) {
      newLength = newLength + array[i] - '0';
      i = i + 2;
    }
    System.out.println(newLength);
    char[] result = new char[newLength];
    int j = newLength - 1;
    int index = input.length() - 1;
    int num = 0;
    while (index >= 0) {
      if (isDigit(array[index])) {
        num = array[index] - '0';
        index--;
      } else {
        for (int k = 0; k < num; k++) {
          result[j--] = array[index];
        }
        index--;
      }
    }
    return new String(result);
  }
  
  public boolean isDigit(char digit) {
    if (digit - '0' >= 0 && digit - '9' <= 0) {
      return true;
    }
    return false;
  }
  
  public static void main(String[] args) {
    String input1 = "a4b1c2a5";
    StringDecode d = new StringDecode();
    System.out.println(d.decode(input1));
  }
}