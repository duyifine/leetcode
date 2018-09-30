package dataStructure;

public class TicTacToe {
  private int n;
  private int[] rows = new int[n];
  private int[] cols = new int[n];
  private int diag;
  private int rev_diag;
  
  public TicTacToe(int n) {
    this.n = n;
  }
  
  public int move(int row, int col, int player) {
    int add = player == 1 ? 1 : -1;
    rows[row] = rows[row] + add;
    cols[col] = cols[col] + add;
    if (row == col) {
      diag = diag + add;
    } else if (row == -col) {
      rev_diag = rev_diag + add;
    }
    if (rows[row] == n || cols[col] == n || diag == n || rev_diag == n) {
      return player;
    }
    return 0;
  }
}