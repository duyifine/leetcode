package string;

public class CharRemoval {
  
  public String removeUN(String input) {
    if (input == null || input.length() == 0) {
      return null;
    }
    
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (array[fast] == 'u' || array[fast] == 'n') {
        continue;
      } 
      array[slow++] = array[fast];
    }
    
    return new String(array, 0, slow);
  }
  
  public static void main(String[] args) {
    CharRemoval c = new CharRemoval();
    String input = "student";
    System.out.println(c.removeUN(input));
  }
}