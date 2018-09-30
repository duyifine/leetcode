package geedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
  
  public static class Interval {
    int start;
    int end;
    Interval() {
      this.start = 0;
      this.end = 0;
    }
    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
  
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    
    Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    queue.offer(intervals[0].end);
    int count = 1;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < queue.peek()) {
        count++;
      } else {
        queue.poll();
      }
      queue.offer(intervals[i].end);
    }
    return count;
  }
  
  public static void main(String[] args) {
    MeetingRoom m = new MeetingRoom();
    Interval[] intervals = {new Interval(0,10), new Interval(5,15), new Interval(10,20)};
    System.out.println(m.minMeetingRooms(intervals));
  }
}