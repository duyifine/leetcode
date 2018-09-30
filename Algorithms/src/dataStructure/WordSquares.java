package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
  
  class TrieNode {
    TrieNode[] children;
    boolean isWord;
    
    TrieNode() {
      children = new TrieNode[26];
    }
  }
  
  public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode current = root;
      for (char c : word.toCharArray()) {
        int index = c - 'a';
        if (current.children[index] == null) {
          current.children[index] = new TrieNode();
        }
        current = current.children[index];
      }
      current.isWord = true;
    }
    
    return root;
  }
  
  public TrieNode search(TrieNode root, String prefix) {
    TrieNode current = root;
    for (char c : prefix.toCharArray()) {
      int index = c - 'a';
      if (current.children[index] == null) {
        return null;
      }
      current = current.children[index];
    }
    return current;
  }
  
  public List<List<String>> wordSquares(String[] words) {
    List<List<String>> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    
    TrieNode root = buildTrie(words);
    for (String word : words) {
      List<String> square = new ArrayList<>();
      square.add(word);
      helper(root, word.length(), square, result);
    }
    
    return result;
  }
  
  public void helper(TrieNode root, int len, List<String> square, List<List<String>> result) {
    if (square.size() == len) {
      result.add(new ArrayList<>(square));
      return;
    }
    
    String prefix = getPrefix(square, square.size());
    TrieNode node = search(root, prefix);
    if (node == null) {      
      return;
    }
    
    List<String> children = new ArrayList<>();
    getChildren(node, prefix, children);
    for (String child : children) {
      square.add(child);
      helper(root, len, square, result);
      square.remove(square.size() - 1);
    }
  }
  
  public String getPrefix(List<String> square, int index) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < index; i++) {
      sb.append(square.get(i).charAt(index));
    }
    return sb.toString();
  }
  
  public void getChildren(TrieNode node, String prefix, List<String> children) {
    if (node.isWord) {
      children.add(prefix);
      return;
    }
    
    for (int i = 0; i < 26; i++) {
      if (node.children[i] != null) {
        getChildren(node.children[i], prefix + (char) ('a' + i), children);
      }
    }
  }
  
  public static void main(String[] args) {
    WordSquares t = new WordSquares();
    String[] words = {"area", "lead", "wall", "lady", "ball"};
    System.out.println(t.wordSquares(words));
    String[] words2 = {"baba", "abat", "atan", "atal"};
    System.out.println(t.wordSquares(words2));
  }
}