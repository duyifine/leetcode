package string;

public class SpaceRemoval {
  
  public String removeSpaces(String input) {
    if (input == null || input.length() == 0) {
      return null;
    }
    
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 0;
    boolean isLeadingSpace = false;
    if (array[0] == ' ') {
      isLeadingSpace = true;
    }
    boolean hasSpace = false;
    while (fast < array.length) {
      while (fast < array.length && array[fast] == ' ') {
        fast++;
        hasSpace = true;
      }
      if (fast == array.length) break;
      if (isLeadingSpace == false && hasSpace){
        array[slow++] = ' ';
      }
      while (fast < array.length && array[fast] != ' ') {
        array[slow++] = array[fast++];
        isLeadingSpace = false;
        hasSpace = false;
      } 
    }
    return new String(array, 0, slow);
  }
  
  public static void main(String[] args) {
    String input = " abc   ed ef  ";
    SpaceRemoval s = new SpaceRemoval();
    System.out.println(s.removeSpaces(input));
  }
}