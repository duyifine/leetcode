package dataStructure;

import java.util.HashMap;

public class TrieImpl {
  
  static class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;
    public TrieNode() {
      
    }
    public TrieNode(char c) {
      this.c = c;
    }
  }
  
  private TrieNode root;
  
  public TrieImpl() {
    root = new TrieNode();
  }
  
  public void insert(String word) {
    HashMap<Character, TrieNode> children = root.children;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      
      TrieNode t;
      if (children.containsKey(c)) {
        t = children.get(c);
      } else {
        t = new TrieNode(c);
        children.put(c, t);
      }
      
      children = t.children;
      
      if (i == word.length() - 1) {
        t.isLeaf = true;
      }
    }
  }
  
  public boolean search(String word) {
    TrieNode t = searchNode(word);
    
    if (t != null && t.isLeaf) {
      return true;
    }
    return false;
  }
  
  public TrieNode searchNode(String word) {
    HashMap<Character, TrieNode> children = root.children;
    TrieNode t = null;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (children.containsKey(c)) {
        t = children.get(c);
        children = t.children;
      } else {
        return null;
      }
    }
    return t;
  }
  
  public boolean startsWith(String prefix) {
    if (searchNode(prefix) == null) {
      return false;
    }
    
    return true;
  }
}