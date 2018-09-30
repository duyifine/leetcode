package design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
  
  public static class TrieNode {
    public char value;
    public TrieNode[] children;
    public boolean isWord;
    
    public TrieNode() {}
    public TrieNode(char c) {
      this.value = c;
    }
  }
  
  public void buildTrie(TrieNode root, String[] words) {
    for (String word : words) {
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
  }
  
  int[] dr = {-1, 1, 0, 0};
  int[] dc = {0, 0, -1, 1};
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    if (board == null || board.length == 0 || words == null || words.length == 0) return result;
    
    TrieNode root = new TrieNode();
    buildTrie(root, words);
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (root.children[board[i][j] - 'a'] != null) {
          StringBuilder sb = new StringBuilder();
          dfs(board, i, j, set, root, sb);
        }
      }
    }
    
    return new ArrayList<>(set);
  }
  
  public void dfs(char[][] board, int r, int c, HashSet<String> set, TrieNode root, StringBuilder sb) {
    if (root == null) return;
    char val = board[r][c];
    int len = sb.length();
    sb.append(val);
    board[r][c] = '#';
    if (root.isWord) set.add(sb.toString());
    
    for (int i = 0; i < 4; i++) {
      int x = r + dr[i];
      int y = c + dc[i];
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
        dfs(board, x, y, set, root.children[board[x][y] - 'a'], sb);
      }
    }
    sb.setLength(len);
    board[r][c] = val;
  }
}