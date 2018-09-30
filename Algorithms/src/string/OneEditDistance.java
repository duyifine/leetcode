package string;

public class OneEditDistance {
  
  public boolean isOneEditDistance(String s, String t) {
    if (s == null || t == null) {
      return false;
    }
    
    int m = s.length();
    int n = t.length();
    
    if (Math.abs(m - n) > 1) {
      return false;
    }
    
    int count = 0;
    if (m == n) {
      for (int i = 0; i < m; i++) {
        if (s.charAt(i) != t.charAt(i)) {
          count++;
        }
      }
    } else {
      int i = 0;
      int j = 0;
      while (i < m && j < n) {
        if (s.charAt(i) == t.charAt(j)) {
          i++;
          j++;
        } else {
          count++;
          if (m > n) {
            i++;
          } else {
            j++;
          }
        }
      }
      if (i < m || j < n) {
        count++;
      }
    }
    
    if (count == 1) {
      return true;
    }
    return false;
  }
  
  public static void main(String[] args) {
    OneEditDistance o = new OneEditDistance();
    String s = "abcde";
    String t1 = "bdce";
    String t2 = "acde";
    String t3 = "abcde";
    String t4 = "abcdd";
    System.out.println(o.isOneEditDistance(s, t1));
    System.out.println(o.isOneEditDistance(s, t2));
    System.out.println(o.isOneEditDistance(s, t3));
    System.out.println(o.isOneEditDistance(s, t4));
  }
}