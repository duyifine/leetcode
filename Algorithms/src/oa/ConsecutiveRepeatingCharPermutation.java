package oa;

public class ConsecutiveRepeatingCharPermutation {
  
  public int numOfCharArray(char[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    
    int i = 0;
    int j = 0;
    int result = 0;
    while (j < array.length) {
      while (j < array.length - 1 && array[j] == array[j + 1]) {
        j++;
      }
      j++;
      int count = j - i;
      result = result + (count * (count + 1))/ 2;
      i = j;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    ConsecutiveRepeatingCharPermutation t = new ConsecutiveRepeatingCharPermutation();
    char[] array = {'z','z','z','y','z'};
    System.out.println(t.numOfCharArray(array));
    char[] array2 = {'z', 'z', 'z'};
    System.out.println(t.numOfCharArray(array2));
    char[] array3 = {'a','b','c', 'c'};
    System.out.println(t.numOfCharArray(array3));
  }
}