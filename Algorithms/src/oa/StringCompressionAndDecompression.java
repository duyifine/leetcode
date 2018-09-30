package oa;

public class StringCompressionAndDecompression {
  
  public String compress(String input) {
    if (input == null || input.length() == 0) return "";
    
    char[] array = input.toCharArray();
    char[] result = new char[array.length * 2];
    
    int i = 0;
    int j = 0;
    while (i < input.length()) {
      result[j++] = array[i];
      int count = 1;
      while (i < input.length() - 1 && array[i] == array[i + 1]) {
        i++;
        count++;
      }
      for (char c : Integer.toString(count).toCharArray()) {
        result[j++] = c;
      }
      i++;
    }
    String s = new String(result, 0, i);
    System.out.println("length=" + s.length());
    
    return s;
  }
  
  public String decompress(String input) {
    if (input == null || input.length() == 0) return input;
    
    char[] array = input.toCharArray();
    int i = 1;
    int newLength = 0;
    while (i < array.length) {
      newLength = newLength + array[i] - '0';
      i = i + 2;
    }
    
    char[] result = new char[newLength];
    int j = newLength - 1;
    int index = input.length() - 1;
    int count = 0;
    while (index >= 0) {
      if (Character.isDigit(array[index])) {
        count = array[index--] - '0';
      } else {
        for (int r = 0; r < count; r++) {
          result[j--] = array[index];
        }
        index--;
      }
    }
    
    return new String(result);
  }
  
  public String decompressII(String input) {
    if (input == null || input.length() == 0) return input;
    
    char[] array = input.toCharArray();
    
    char cur = array[0];
    int index = 1;
    StringBuilder sb = new StringBuilder();
    while (index <= input.length()) {
      int count = 0;
      while (index < input.length() && Character.isDigit(array[index])) {
        count = count * 10 + array[index] - '0';
        index++;
      }
      for (int i = 0; i < count; i++) {
        sb.append(cur);
      }
      if (index < input.length()) {
        cur = array[index++];
      } else if (index == input.length()) {
        index++;
      }
    }
    
    return sb.toString();
  }
  
  public static void main(String[] args) {
    StringCompressionAndDecompression s = new StringCompressionAndDecompression();
    String input = "wwwwaaadexxxxxx";
    String output = s.compress(input);
    System.out.println(output);
    System.out.println(s.decompress("w4a3d1e1x6"));
    String input2 = "aaaabbbbcccd";
    System.out.println(s.compress(input2));
    System.out.println(s.decompress("a4b4c3d1"));
    System.out.println(s.decompressII("a10b14c3d1"));
  }
}