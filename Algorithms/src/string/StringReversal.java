package string;

public class StringReversal {
  
  public String reverse(String input) {
    if (input == null || input.length() == 0 || input.length() == 1) {
      return input;
    }
    
    char[] array = input.toCharArray();
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      swap(array, i++, j--);
    }
    
    return new String(array);
  }
  
  public void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  
  public String reverseRecursive(String s) {
    if (s == null || s.length() == 0 || s.length() == 1) {
      return s;
    }
    
    char[] array = s.toCharArray();
    helper(array, 0, array.length - 1);
    return new String(array);
  }
  
  public void helper(char[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    
    swap(array, left, right);
    helper(array, left + 1, right - 1);
  }
  
  public static void main(String[] args) {
    String s = "hello";
    StringReversal t = new StringReversal();
    System.out.println(t.reverseRecursive(s));
  }
}