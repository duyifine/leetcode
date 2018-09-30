package string;

public class SentenceReversal {
  
  public String reverseSentence(String input) {
    if (input == null || input.length() == 0) {
      return null;
    }
    
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      while (fast < array.length && array[fast] == ' ') {
        fast++;
      }
      slow = fast;
      while (fast < array.length && array[fast] != ' ') {
        fast++;
      }
      reverseString(array, slow, fast - 1);
    }
    reverseString(array, 0, array.length - 1);
    
    return new String(array);
  }
  
  public void reverseString(char[] array, int i, int j) {
    while (i < j) {
      swap(array, i++, j--);
    }
  }
  
  public void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  
  public static void main(String[] args) {
    String input = "I love coding";
    SentenceReversal s = new SentenceReversal();
    System.out.println(s.reverseSentence(input));
    String input2 = "  Hello  world!";
    System.out.println(s.reverseSentence(input2));
  }
}