package string;

public class ShortestWordDistance {
  public int shortestDistance(String[] words, String word1, String word2) {
    if (words == null || words.length == 0 || word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
      return -1;
    }
    
    int word1_index = -1;
    int word2_index = -1;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      if (words[i] == word1) {
        word1_index = i;
        if (word2_index != -1) {
          result = Math.min(result, Math.abs(word1_index - word2_index));
        }
      } else if (words[i] == word2) {
        word2_index = i;
        if (word1_index != -1) {
          result = Math.min(result, Math.abs(word1_index - word2_index));
        }
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "practice";
    String word2 = "perfect";
    ShortestWordDistance s = new ShortestWordDistance();
    System.out.println(s.shortestDistance(words, word1, word2));
    String word3 = "coding";
    String word4 = "makes";
    System.out.println(s.shortestDistance(words, word3, word4));
  }
}