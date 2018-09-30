package array;

import java.util.HashMap;

public class MostPointsOnLine {
  
  public static class Point {
    int x;
    int y;
    Point() {
      x = 0;
      y = 0;
    }
    Point(int a, int b) {
      x = a;
      y = b;
    }
  }
  
  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    
    int result = 1;
    for (int i = 0; i < points.length; i++) {
      Point seed = points[i];
      HashMap<Double, Integer> slopeSet = new HashMap<Double, Integer>();
      int same = 1;
      int vertical = 0;
      int max = 0;
      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }
        Point end = points[j];
        if (seed.x == end.x && seed.y == end.y) {
          same++;
        } else if (seed.x == end.x) {
          vertical++;
        } else {
          double slope = (double) (seed.x - end.x) / (seed.y - end.y);
          if (!slopeSet.containsKey(slope)) {
            slopeSet.put(slope, 1);
          } else {
            slopeSet.put(slope, slopeSet.get(slope) + 1);
          }
          max = Math.max(max, slopeSet.get(slope));
        }
      }
      max = Math.max(max, vertical) + same;
      result = Math.max(result, max);
    }
    return result;
  }
}