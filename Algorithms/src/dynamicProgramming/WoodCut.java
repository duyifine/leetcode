package dynamicProgramming;

public class WoodCut {
  
  public int cut(int[] cuts) {
    if (cuts == null) {
      return 0;
    }
    
    int[][] costs = new int[cuts.length][cuts.length];
    for (int i = 0; i < cuts.length - 1; i++) {
      costs[i][i + 1] = 0;
    }
/**    for (int i = 0; i < cuts.length - 2; i++) {
      costs[i][i + 2] = cuts[i + 2] - cuts[i];
    }**/
    
    for (int i = 2; i < cuts.length; i++) {
      for (int j = 0; j < i - 1; j++) {
        costs[j][i] = Integer.MAX_VALUE;
        for (int k = j + 1; k <= i - 1; k++) {
          costs[j][i] = Math.min(costs[j][i], costs[j][k] + costs[k][i]);
        }
        costs[j][i] = cuts[i] - cuts[j] + costs[j][i];
      }
    }
    
    return costs[0][cuts.length - 1];
  }
  
  public static void main(String[] args) {
    int[] cuts = {0,2,4,7,10};
    WoodCut w = new WoodCut();
    System.out.println(w.cut(cuts));
  }
}