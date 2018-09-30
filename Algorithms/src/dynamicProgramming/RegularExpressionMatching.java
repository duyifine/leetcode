package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegularExpressionMatching {
  
  public boolean regMatch(String s, String p) {
    if (p == null || p.length() == 0) return s == null || s.length() == 0;
    
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int j = 1; j <= p.length(); j++) {
      if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
        dp[0][j] = true;
      }
    }
    
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else if (p.charAt(j) == '*') {
          if (j > 0 && p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          } else if (j > 0 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
          }
        } else if (p.charAt(j) == '+') {
  //        if (j > 0 && p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
  //          dp[i + 1][j + 1] = dp[i + 1][j];
  /**        } else **/if (j > 0 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
          }
        }
      }
    }
    
    return dp[s.length()][p.length()];
  }
  
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
        return false;
    }
    
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i - 1]) {
            dp[0][i + 1] = true;
        }
    }
    
    for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (s.charAt(i) == p.charAt(j)) {
                dp[i + 1][j + 1] = dp[i][j];
            } else if (p.charAt(j) == '.') {
                dp[i + 1][j + 1] = dp[i][j];
            } else if (p.charAt(j) == '*') {
                if (j > 0 && p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1]; //B* counts as empty
                } else if (j > 0 && p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
                    //A/.* counts as multiple || A/.* counts as single || A/.* counts as empty
                }
            }
        }
    }
    
    return dp[s.length()][p.length()];
  }
  
  public static class UnitTest {
    @Test
    public void test1() {
      RegularExpressionMatching s = new RegularExpressionMatching();
      assertTrue(s.regMatch("saaaa", "s+a*"));
      assertTrue(s.regMatch("sa", "s+a*"));
      assertFalse(s.regMatch("saaaa", "s+b*"));
      assertFalse(s.regMatch("saaaab", "s+a*"));
      assertFalse(s.regMatch("saaaab", "s+b*"));
      assertTrue(s.regMatch("abcdddd", ".*d"));
      assertTrue(s.regMatch("abcdddd", ".+d"));
      assertFalse(s.regMatch("a", ".+a"));
      assertTrue(s.regMatch("a", ".*a"));
    }
    
    @Test
    public void test2() {
      RegularExpressionMatching s2 = new RegularExpressionMatching();
      assertTrue(s2.isMatch("a", ".*a"));
    }
  }
}