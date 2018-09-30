package string;

public class WordsReversal {
  
  public String reverseWords(String s) {
    if (s == null || s.length() == 0 || s.length() == 1) {
      return s;
    }
    
    char[] array = s.toCharArray();
    int i = 0;
    while (i < array.length) {
      int j = i;
      while (j < array.length && array[j] != ' ') {
        j++;
      }
      reverse(array, i, j - 1);
      i = j;
      while (i < array.length && array[i] == ' ') {
        i++;
      }
    }
    
    reverse(array, 0, array.length - 1);
    return new String(array);
  }
  
  public void reverse(char[] array, int i, int j) {
    while (i < j) {
      swap(array, i++ , j--);
    }
  }
  
  public void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  
  public static void main(String[] args) {
    String s = "I love Yahoo";
    WordsReversal w = new WordsReversal();
    System.out.println(w.reverseWords(s));
  }
}