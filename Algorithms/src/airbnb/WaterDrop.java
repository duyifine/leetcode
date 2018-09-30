package airbnb;

import java.util.Arrays;

public class WaterDrop {
  
  public void pourWater(int[] heights, int location, int drops) {
    if (heights == null || heights.length == 0 || drops <= 0) return;
    print(heights);
    
    int[] water = new int[heights.length];
    while (drops > 0) {
      int left = findLeftMinIdx(heights, location);
      if (left < location) {
        water[left]++;
        heights[left]++;
      } else {
        int right = findRightMinIdx(heights, location);
        if (right > location) {
          water[right]++;
          heights[right]++;
        } else {
          water[location]++;
          heights[location]++;
        }
      }
      drops--;
    }
    
    print(heights, water);
  }
  
  public void pourWaterII(int[] heights, int location, int drops) {
    if (heights == null || heights.length == 0 || drops <= 0) return;
    print(heights);
    
    int[] copy = new int[heights.length + 2];
    copy[0] = Integer.MIN_VALUE;
    copy[copy.length - 1] = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      copy[i + 1] = heights[i];
    }
    int[] water = new int[copy.length];
    while (drops > 0) {
      int left = findLeftMinIdx(copy, location);
      if (left < location) {
        water[left]++;
        copy[left]++;
      } else {
        int right = findRightMinIdx(copy, location);
        if (right > location) {
          water[right]++;
          copy[right]++;
        } else {
          water[location]++;
          copy[location]++;
        }
      }
      drops--;
    }
    
    print(Arrays.copyOfRange(copy, 1, copy.length - 1), Arrays.copyOfRange(water, 1, water.length - 1));
  }
  
  public int findLeftMinIdx(int[] heights, int location) {
    int min = heights[location];
    int idx = location;
    for (int i = location; i >= 0; i--) {
      if (heights[i] < min) {
        min = heights[i];
        idx = i;
      } else if (heights[i] > min) {
        break;
      }
    }
    return idx;
  }
  
  public int findRightMinIdx(int[] heights, int location) {
    int min = heights[location];
    int idx = location;
    for (int i = location; i < heights.length; i++) {
      if (heights[i] < min) {
        min = heights[i];
        idx = i;
      } else if (heights[i] > min) {
        break;
      }
    }
    return idx;
  }
  
  public void print(int[] heights) {
    int maxHeight = 0;
    for (int i = 0; i < heights.length; i++) {
      maxHeight = Math.max(maxHeight, heights[i]);
    }
    
    for (int height = maxHeight; height > 0; height--) {
      for (int i = 0; i < heights.length; i++) {
        if (heights[i] >= height) {
          System.out.print("+");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
  
  public void print(int[] heights, int[] water) {
    int maxHeight = 0;
    for (int i = 0; i < heights.length; i++) {
      maxHeight = Math.max(maxHeight, heights[i]);
    }
    
    for (int height = maxHeight; height > 0; height--) {
      for (int i = 0; i < heights.length; i++) {
        if (heights[i] >= height) {
          if (water[i] > 0) {
            System.out.print("w");
            water[i]--;
          } else {
            System.out.print("+");
          }
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    WaterDrop sol = new WaterDrop();
    int[] heights = {2,1,1,2,1,2,2};
    int location = 3;
    int drops = 4;
    sol.pourWaterII(heights, location, drops);
  }
}