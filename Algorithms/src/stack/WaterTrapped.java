package stack;

public class WaterTrapped {
  
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    
    for (int i = 1; i < leftMax.length; i++) {
      leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
    }
    
    for (int i = rightMax.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
    }
    
    int result = 0;
    for (int i = 0; i < height.length; i++) {
      result = result + Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
    }
    return result;
  }
}