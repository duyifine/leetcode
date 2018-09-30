package airbnb;

import java.util.ArrayList;
import java.util.List;

public class KEditDistance {
  
  public static class TrieNode {
    char value;
    TrieNode[] children = new TrieNode[26];
    String str;
    boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char c) {
      value = c;
    }
  }
  
  public void insert(TrieNode root, String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode(c);
      }
      cur = cur.children[c - 'a'];
    }
    cur.isLeaf = true;
    cur.str = word;
  }
  
  public List<String> kDistance(String[] words, String target, int k) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0 || k < 0 || target == null) return result;
    
    TrieNode root = new TrieNode();
    for (String word : words) {
      insert(root, word);
    }
    
    int[] dp = new int[target.length() + 1];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = i;
    }
    
    helper(root, dp, target, result, k);
    
    return result;
  }
  
  public void helper(TrieNode node, int[] dp, String target, List<String> result, int k) {
    int len = target.length();
    if (node.isLeaf && dp[len] <= k) {
      result.add(node.str);
    }
    
    for (int i = 0; i < 26; i++) {
      if (node.children[i] != null) {
        int[] next = new int[len + 1];
        next[0] = dp[0] + 1;
        for (int j = 1; j <= len; j++) {
          if (target.charAt(j - 1) - 'a' == i) {
            next[j] = dp[j - 1];
          } else {
            next[j] = Math.min(dp[j - 1] + 1, Math.min(next[j - 1] + 1, dp[j] + 1));
          }
        }
        helper(node.children[i], next, target, result, k);
      }
    }
  }
}