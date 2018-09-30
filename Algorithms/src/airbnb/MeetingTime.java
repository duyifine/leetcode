package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingTime {
  
  public static class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
  
  public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
    List<Interval> result = new ArrayList<>();
    if (intervals == null || intervals.size() == 0) return result;
    
    List<int[]> pointList = new ArrayList<>();
    for (List<Interval> intervalList : intervals) {
      for (Interval interval : intervalList) {
        pointList.add(new int[] {interval.start, 0});
        pointList.add(new int[] {interval.end, 1});
      }
    }
    
    Collections.sort(pointList, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        if (i1[0] < i2[0]) {
          return -1;
        } else if (i1[0] > i2[0]) {
          return 1;
        } else {
          return i1[1] - i2[1];
        }
      }
    });
    
    int count = 0;
    Integer start = null;
    for (int i = 0; i < pointList.size(); i++) {
      int[] point = pointList.get(i);
      if (point[1] == 0) {
        count++;
        if (start == null && count <= intervals.size() - k) {
          start = point[0];
        } else if (start != null && count == intervals.size() - k + 1) {
          result.add(new Interval(start, point[0]));
          start = null;
        }
      } else if (point[1] == 1) {
        count--;
        if (count == intervals.size() - k && i < pointList.size() - 1) {
          start = point[0];
        } else if (start != null && i == pointList.size() - 1 && count <= intervals.size() - k) {
          result.add(new Interval(start, point[0]));
        }
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    MeetingTime sol = new MeetingTime();
    List<List<Interval>> intervals = new ArrayList<List<Interval>>() {{
      add(new ArrayList<Interval>() {{
          add(new Interval(1, 3));
          add(new Interval(6, 7));
      }});
      add(new ArrayList<Interval>() {{
          add(new Interval(2, 4));
      }});
      add(new ArrayList<Interval>() {{
          add(new Interval(2, 3));
          add(new Interval(9, 12));
      }});
    }};
    List<Interval> result1 = sol.getAvailableIntervals(intervals, 2);
    for (Interval interval : result1) {
      System.out.println(interval.start);
      System.out.println(interval.end);
      System.out.println("\n");
    }
  }
}