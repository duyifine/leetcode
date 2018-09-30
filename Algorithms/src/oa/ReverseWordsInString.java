package oa;

public class ReverseWordsInString {
  
  public String reverseWords(String s) {
    if (s == null || s.length() == 0) return s;
    
    s = s.trim();
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
    StringBuilder sb = new StringBuilder();
    int k = 0;
    while (k < array.length) {
      while (k < array.length && array[k] != ' ') {
        sb.append(array[k++]);
      }
      if (k < array.length && array[k] == ' ') {
        while (k < array.length && array[k] == ' ') {
          k++;
        }
        sb.append(' ');
      }
    }
    
    return sb.toString();
  }
  
  public void reverse(char[] array, int i, int j) {
    while (i < j) {
      swap(array, i++, j--);
    }
  }
  
  public void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}