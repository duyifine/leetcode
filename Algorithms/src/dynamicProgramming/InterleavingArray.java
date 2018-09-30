package dynamicProgramming;

public class InterleavingArray {
  
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1 == null || s2 == null || s3 == null) {
      return false;
    }    
    int l1 = s1.length();
    int l2 = s2.length();
    int l3 = s3.length();
    if (l1 + l2 != l3) {
      return false;
    }
    
    boolean[][] canMerge = new boolean[l1 + 1][l2 + 1];
    canMerge[0][0] = true;
    for (int i = 0; i < l1; i++) {
      if (canMerge[i][0] && s1.charAt(i) == s3.charAt(i)) {
        canMerge[i + 1][0] = true;
      }
    }
    for (int i = 0; i < l2; i++) {
      if (canMerge[0][i] && s2.charAt(i) == s3.charAt(i)) {
        canMerge[0][i + 1] = true;
      }
    }
    for (int i = 0; i < l1; i++) {
      for (int j = 0; j < l2; j++) {
        if ((canMerge[i + 1][j] && s3.charAt(i + j + 1) == s2.charAt(j))
            || (canMerge[i][j + 1] && s3.charAt(i + j + 1) == s1.charAt(i))) {
          canMerge[i + 1][j + 1] = true;
        }
      }
    }
    
    return canMerge[l1][l2];
  }
}