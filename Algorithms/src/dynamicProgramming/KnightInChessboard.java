package dynamicProgramming;

public class KnightInChessboard {
  int[] dx = {-2, -1, 2, 1, -2, -1, 2, 1};
  int[] dy = {1, 2, 1, 2, -1, -2, -1, -2};
  
  public double knightProbability(int N, int K, int r, int c) {
    if (N == 0) {
      return 0.0;
    }
    if (K == 0) {
      return 1.0;
    }
    
    double[][][] prob = new double[N][N][K + 1];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        prob[i][j][0] = 1.0;
      }
    }
    
    for (int s = 1; s <= K; s++) {
      for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
          for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (inside(nx, ny, N)) {
              prob[x][y][s] = prob[x][y][s] + prob[nx][ny][s - 1] / 8.0; 
            }
          }
        }
      }
    }
    
    return prob[r][c][K];
  }
  
  public boolean inside(int x, int y, int N) {
    if (x >= N || y >= N || x < 0 || y < 0) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    int N = 3;
    int K = 2;
    int r = 0;
    int c = 0;
    KnightInChessboard t = new KnightInChessboard();
    System.out.println(t.knightProbability(N, K, r, c));
  }
}