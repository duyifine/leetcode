package airbnb;

public class PourWater {
  
  public int[] pourWater(int[] heights, int V, int K) {
    if (heights == null || heights.length == 0 || V <= 0 || K < 0) return new int[0];
    
    for (int i = 0; i < V; i++) {
      int leftMinIdx = findLeftMinIdx(heights, K);
      if (leftMinIdx < K) {
        heights[leftMinIdx]++;
      } else {
        int rightMinIdx = findRightMinIdx(heights, K);
        if (rightMinIdx > K) {
          heights[rightMinIdx]++;
        } else {
          heights[K]++;
        }
      }
    }
    
    return heights;
  }
  
  public int findLeftMinIdx(int[] heights, int K) {
    int min = heights[K];
    int minIdx = K;
    for (int i = K - 1; i >= 0; i--) {
      if (heights[i] < min) {
        min = heights[i];
        minIdx = i;
      } else if (heights[i] > min) {
        break;
      }
    }
    
    return minIdx;
  }
  
  public int findRightMinIdx(int[] heights, int K) {
    int min = heights[K];
    int minIdx = K;
    for (int i = K + 1; i < heights.length; i++) {
      if (heights[i] < min) {
        min = heights[i];
        minIdx = i;
      } else if (heights[i] > min) {
        break;
      }
    }
    
    return minIdx;
  }
}