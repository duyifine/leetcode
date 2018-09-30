package dynamicProgramming;

public class EditDistance {
  
  public int minDistance(String word1, String word2) {
    if (word1.isEmpty()) {
      return word2.length();
    }
    if (word2.isEmpty()) {
      return word1.length();
    }
    
    int noOps = Integer.MAX_VALUE;
    if (word1.charAt(0) == word2.charAt(0)) {
      noOps = minDistance(word1.substring(1), word2.substring(1));
    }
    
    int replace = 1 + minDistance(word1.substring(1), word2.substring(1));
    int delete = 1 + minDistance(word1.substring(1), word2);
    int insert = 1 + minDistance(word1, word2.substring(1));
    
    return Math.min(Math.min(delete, insert), Math.min(noOps, replace));
  }
  
  public int minDistanceDp(String word1, String word2) {
    if ((word1 == null && word2 == null) || (word1.length() == 0 && word2.length() == 0)) {
      return 0;
    }
    
    int[][] minDistance = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word2.length(); i++) {
      minDistance[0][i] = i;
    }
    for (int i = 0; i <= word1.length(); i++) {
      minDistance[i][0] = i;
    }
    
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          minDistance[i][j] = minDistance[i - 1][j - 1];
        } else {
          minDistance[i][j] = 1 + Math.min(minDistance[i - 1][j], Math.min(minDistance[i][j - 1], minDistance[i - 1][j - 1]));
        }
      }
    }
    return minDistance[word1.length()][word2.length()];
  }
  
  public static void main(String[] args) {
    String word1 = "asdf";
    String word2 = "sghj";
    EditDistance e = new EditDistance();
    System.out.println(e.minDistance(word1, word2));
  }
}