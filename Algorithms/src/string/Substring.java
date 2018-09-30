package string;

public class Substring {
  
  public int strstr(String large, String small) {
    if (large == null || large.length() == 0 || small == null || small.length() > large.length()) {
      return -1;
    }
    if (small.length() == 0)
    {
      return 0;
    }
    
    int i = 0;
    while (i + small.length() < large.length()) {
      if (large.charAt(i) == small.charAt(0)) {
        int j = 0;
        while (j < small.length() && large.charAt(i + j) == small.charAt(j)) {
          j++;
        }
        if (j == small.length()) {
          return i;
        }
      }
      i++;
    }
    return -1;
  }
  
  public static void main(String[] args) {
    String large = "abcde";
    String small = "cd";
    Substring s = new Substring();
    System.out.println(s.strstr(large, small));
  }
}