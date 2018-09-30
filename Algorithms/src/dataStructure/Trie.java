package dataStructure;

import java.util.HashMap;

public class Trie {
  class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;
    public TrieNode() {
      children = new HashMap<>();
      isWord = false;
    }
  }
  
  TrieNode root;
  public Trie() {
    root = new TrieNode();
  }
  
  public void insert(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!cur.children.containsKey(c)) {
        cur.children.put(c, new TrieNode());
      }
      cur = cur.children.get(c);
    }
    cur.isWord = true;
  }
  
  public boolean findWord(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!cur.children.containsKey(c)) {
        return false;
      }
      cur = cur.children.get(c);
    }
    return cur.isWord;
  }
  
  public boolean findPrefix(String prefix) {
    TrieNode cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (!cur.children.containsKey(c)) {
        return false;
      }
      cur = cur.children.get(c);
    }
    return true;
  }
}