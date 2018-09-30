package array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSetPointsPositiveSlope {
  
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
  
  public int largest(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    
    Arrays.sort(points, new Comparator<Point>() {
      @Override
      public int compare(Point p1, Point p2) {
        if (p1.x < p2.x) {
          return -1;
        } else if (p1.x > p2.x) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    
    int result = 1;
    int[] longest = new int[points.length];
    for (int i = 0; i < longest.length; i++) {
      longest[i] = 1;
    }
    for (int i = 1; i < points.length; i++) {
      for (int j = 0; j < i; j++) {
        if (points[j].x < points[i].x && points[j].y < points[i].y) {
          longest[i] = Math.max(longest[j] + 1, longest[i]);
        }
      }
      result = Math.max(result, longest[i]);
    }
    return result;
  }
}