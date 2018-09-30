package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
  
  public static class Interval {
    int start;
    int end;
    Interval() {
      start = 0;
      end = 0;
    }
    Interval(int s, int e) {
      this.start = s;
      this.end = e;
    }
  }
  
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0 || intervals.size() == 1) {
      return intervals;
    }
    
    List<Interval> result = new ArrayList<Interval>();
    intervals.sort((Interval i1, Interval i2) -> i1.start - i2.start);
    int end = intervals.get(0).end;
    int start = intervals.get(0).start;
    for (int i = 1; i < intervals.size(); i++) {
      if (intervals.get(i).start > end) {
        result.add(new Interval(start, end));
        start = intervals.get(i).start;
        end = intervals.get(i).end;
      } else {
        end = Math.max(end, intervals.get(i).end);
      }
    }
    result.add(new Interval(start, end));
    return result;
  }
  
  public static void main(String[] args) {
    Interval i1 = new Interval(1,3);
    Interval i2 = new Interval(2,6);
    Interval i3 = new Interval(8,10);
    Interval i4 = new Interval(15,18);
    List<Interval> intervals = new ArrayList<>();
    intervals.add(i1);
    intervals.add(i2);
    intervals.add(i3);
    intervals.add(i4);
    MergeIntervals m = new MergeIntervals();
    System.out.println(m.merge(intervals));
    Interval r1 = new Interval(1,6);
    Interval r2 = new Interval(8,10);
    Interval r3 = new Interval(15,18);
    List<Interval> expected = new ArrayList<>();
    expected.add(r1);
    expected.add(r2);
    expected.add(r3);
    assert(m.merge(intervals).equals(expected));
  }
}