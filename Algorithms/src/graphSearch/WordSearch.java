package graphSearch;

public class WordSearch {
  
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null || word.length() == 0) return false;
    
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs(board, i, j, word, 0)) {
            return true;
          }
        }
      }
    }
    
    return false;
  }
  
  public boolean dfs(char[][] board, int r, int c, String word, int index) {    
    if (index == word.length() - 1) return true;
    
    char val = board[r][c];
    board[r][c] = '#';
    for (int i = 0; i < 4; i++) {
      int x = r + dx[i];
      int y = c + dy[i];
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(index + 1)) {
        if (dfs(board, x, y, word, index + 1)) {
          return true;
        }
      }
    }
    board[r][c] = val;
    
    return false;
  }
}