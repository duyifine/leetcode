package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearch {
  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
  }
  
  public void buildTrie(String[] words, TrieNode root) {
    for (String word : words) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode();
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
    if (board == null || board.length == 0 || words == null || words.length == 0) {
      return result;
    }
    
    TrieNode root = new TrieNode();
    buildTrie(words, root);
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (root.children[board[i][j] - 'a'] != null) {
          dfs(board, i, j, root.children[board[i][j] - 'a'], set, new StringBuilder());
        }
      }
    }
    
    return new ArrayList<>(set);
  }
  
  public void dfs(char[][] board, int i, int j, TrieNode root, HashSet<String> result, StringBuilder sb) {
    char val0 = board[i][j];
    if (root == null) {
      return;
    }
    int len = sb.length();
    board[i][j] = '#';
    sb.append(val0);
    if (root.isWord) {
      result.add(sb.toString());
    }
    
    for (int index = 0; index < 4; index++) {
      int r = i + dr[i];
      int c = j + dc[i];
      if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] != '#') {
        dfs(board, r, c, root.children[board[r][c] - 'a'], result, sb);
      }
    }
    
    board[i][j] = val0;
    sb.setLength(len);
  }
}