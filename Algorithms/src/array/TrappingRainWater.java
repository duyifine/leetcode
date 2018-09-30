package array;

public class TrappingRainWater {
  public int trap(int[] height) {
    if (height == null || height.length == 0) return 0;
    
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    
    for (int i = 1; i < leftMax.length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
    }
    
    for (int i = rightMax.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
    }
    
    int result = 0;
    for (int i = 0; i < height.length; i++) {
      result = result + Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
    }
    
    return result;
  }
}