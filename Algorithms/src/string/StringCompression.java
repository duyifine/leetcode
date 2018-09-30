package string;

public class StringCompression {
 
  public int compress(char[] chars) {
    if (chars == null || chars.length == 0) {
      return 0;
    }
    
    int slow = 0;
    int fast = 1;
    int resultLen = 0;
    while (fast < chars.length) {
      int count = 1;
      while (fast < chars.length && chars[fast] == chars[slow]) {
        fast++;
        count++;
      }
      if (count == 1) {
        resultLen = resultLen + 1;
      } else {
        resultLen = resultLen + countDigits(count) + 1;
      }
      slow = fast;
      fast++;
    }
    
    return resultLen;
  }
  
  public int countDigits(int num) {
    int count = 0;
    while (num != 0) {
      num = num / 10;
      count++;
    }
    
    return count;
  }
  
  public String compressString(char[] chars) {
    if (chars == null || chars.length == 0) {
      return null;
    }
    
    char[] result = chars;
    int slow = 0;
    int fast = 1;
    int i = 0;
    while (fast < chars.length) {
      int count = 1;
      while (fast < chars.length && chars[fast] == chars[slow]) {
        fast++;
        count++;
      }
      result[i++] = chars[slow];
      if (count > 1) {
        int digits = countDigits(count);
        for (int j = i + digits - 1; j >= i; j--) {
          result[j] = (char) (count % 10 + '0');
          count = count / 10;
        }
        i = i + digits;
      }
      slow = fast;
      fast++;
    }
    return new String(result, 0, i);
  }
  
  public static void main(String[] args) {
    char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    StringCompression s  = new StringCompression();
    System.out.println(s.compress(chars));
    System.out.println(s.compressString(chars));
    char[] chars2 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
    System.out.println(s.compress(chars2));
    System.out.println(s.compressString(chars2));
  }
}