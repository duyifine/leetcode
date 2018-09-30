package graphSearch;

public class AndroidUnlockPatterns {  
  
  public int numberOfPatterns(int m, int n) {
    if (n <= 0) {
      return 0;
    }
    
    int[][] jumps = new int[10][10];
    jumps[1][3] = jumps[3][1] = 2;
    jumps[1][7] = jumps[7][1] = 4;
    jumps[3][9] = jumps[9][3] = 6;
    jumps[7][9] = jumps[9][7] = 8;
    jumps[4][6] = jumps[6][4] = 5;
    jumps[1][9] = jumps[9][1] = 5;
    jumps[3][7] = jumps[7][3] = 5;
    jumps[2][8] = jumps[8][2] = 5;
    
    int result = 0;
    result = result + 4 * dfs(1, 1, m, n, new boolean[10], jumps);
    result = result + 4 * dfs(2, 1, m, n, new boolean[10], jumps);
    result = result + dfs(5, 1, m, n, new boolean[10], jumps);
    
    return result;
  }
  
  public int dfs(int x, int length, int m, int n, boolean[] visited, int[][] jumps) {
    visited[0] = true;
    int count = 0;
    if (length >= m) {
      count++;
    }
    if (length == n) {
      return count;
    }
    
    visited[x] = true;
    for (int i = 1; i <= 9; i++) {
      if (!visited[i] && visited[jumps[x][i]]) {
        count = count + dfs(i, length + 1, m, n, visited, jumps);
        visited[i] = false;
      }
    }
    return count;
  }
  
  public static void main(String[] args) {
    AndroidUnlockPatterns a = new AndroidUnlockPatterns();
    System.out.println(a.numberOfPatterns(1, 2));
  }
}