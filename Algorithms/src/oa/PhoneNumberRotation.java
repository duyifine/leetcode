package oa;

public class PhoneNumberRotation {
  
  public String[] rotateNumbers(String[] numbers) {
    if (numbers == null || numbers.length == 0) return new String[0];
    
    String[] result = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i].length() == 12) {
        char[] array = numbers[i].toCharArray();
        charSwap(array, 0, 4);
        charSwap(array, 1, 5);
        charSwap(array, 2, 6);
        result[i] = new String(array);
      } else if (numbers[i].length() == 10) {
        StringBuilder sb = new StringBuilder();
        sb.append(numbers[i].substring(3, 6));
        sb.append('-');
        sb.append(numbers[i].substring(0, 3));
        sb.append('-');
        sb.append(numbers[i].substring(6, 10));
        result[i] = sb.toString();
      }
    }
    
    return result;
  }
  
  public void charSwap(char[] array, int i, int j) {
    array[i] = (char) (array[i] ^ array[j]);
    array[j] = (char) (array[i] ^ array[j]);
    array[i] = (char) (array[i] ^ array[j]);
  }
  
  public static void main(String[] args) {
    String[] numbers = {"1234567890", "123-456-7890"};
    PhoneNumberRotation s = new PhoneNumberRotation();
    String[] result = s.rotateNumbers(numbers);
    for (String str : result) {
      System.out.println(str);
    }
  }
}