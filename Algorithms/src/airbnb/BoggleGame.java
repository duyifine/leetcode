package airbnb;

import java.util.ArrayList;
import java.util.List;

public class BoggleGame {
  
  public static class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char c) {
      val = c;
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
  }
  
  int[] dr = {0, 0, 1, -1};
  int[] dc = {-1, 1, 0, 0};
  public int boggleGame(char[][] board, String[] words) {
    if (board == null || board.length == 0 || words == null || words.length == 0) return 0;
    
    TrieNode root = new TrieNode();
    for (String word : words) {
      insert(root, word);
    }
    
    boolean[][] visited = new boolean[board.length][board[0].length];
    List<String> result = new ArrayList<>();
    List<String> tmpList = new ArrayList<>();
    findWords(root, board, visited, 0, 0, result, tmpList);
    
    return result.size();
  }
  
  public void findNextWord(TrieNode root, char[][] board, boolean[][] visited, int r, int c, List<List<Integer>> result, List<Integer> path) {
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) return;
    char val = board[r][c];
    if (root.children[val - 'a'] == null) return;
    root = root.children[val - 'a'];
    if (root.isLeaf) {
      List<Integer> pathToAdd = new ArrayList<>(path);
      pathToAdd.add(r * board[0].length + c);
      result.add(pathToAdd);
      return;
    }
    
    visited[r][c] = true;
    path.add(r * board[0].length + c);
    for (int i = 0; i < 4; i++) {
      int x = r + dr[i];
      int y = c + dc[i];
      findNextWord(root, board, visited, x, y, result, path);
    }
    path.remove(path.size() - 1);
    visited[r][c] = false;
  }
  
  public void findWords(TrieNode root, char[][] board, boolean[][] visited, int r, int c, List<String> result, List<String> curWords) {
    for (int i = r; i < board.length; i++) {
      for (int j = c; j < board[0].length; j++) {
        List<List<Integer>> nextWordIndexes = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findNextWord(root, board, visited, i, j, nextWordIndexes, path);
        for (List<Integer> indexes : nextWordIndexes) {
          String word = "";
          for (int index: indexes) {
            int row = index / board[0].length;
            int col = index % board[0].length;
            word = word + board[row][col];
            visited[row][col] = true;
          }
          curWords.add(word);
          if (curWords.size() > result.size()) {
            result.clear();
            result.addAll(curWords);
          }
          findWords(root, board, visited, i, j, result, curWords);
          for (int index: indexes) {
            int row = index / board[0].length;
            int col = index % board[0].length;
            visited[row][col] = false;
          }
          curWords.remove(curWords.size() - 1);
        }
      }
      c = 0;
    }
  }
  
  public static void main(String[] args) {
    char[][] board = new char[][]{
      {'a', 'b', 'c'},
      {'d', 'e', 'f'},
      {'g', 'h', 'i'}
    };
    String[] words = new String[] {
      "abc", "cfi", "beh", "defi", "gh"
    };
    BoggleGame sol = new BoggleGame();
    System.out.println(sol.boggleGame(board, words));
  }
}