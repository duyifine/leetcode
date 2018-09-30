package design;

public class Trie {
  
  public static class TrieNode {
    public char val;
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;
    
    public TrieNode() {}
    
    public TrieNode(char c) {
      this.val = c;
    }
  }
  
  private TrieNode root;
  public Trie() {
    root = new TrieNode();
  }
  
  public void insert(String word) {
    if (word == null || word.length() == 0) return;
    
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode(c);
      }
      cur = cur.children[c - 'a'];
    }
    cur.isWord = true;
  }
  
  public boolean search(String word) {
    if (word == null || word.length() == 0) return false;
    
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (cur.children[c - 'a'] == null) {
        return false;
      } else {
        cur = cur.children[c - 'a'];
      }
    }
    
    return cur.isWord;
  }
  
  public boolean startsWith(String prefix) {
if (prefix == null || prefix.length() == 0) return false;
    
    TrieNode cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (cur.children[c - 'a'] == null) {
        return false;
      } else {
        cur = cur.children[c - 'a'];
      }
    }
    
    return true;
  }
}