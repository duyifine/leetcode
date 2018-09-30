package array;

import java.util.Arrays;

import geedy.MeetingRoom.Interval;

public class MeetingRooms {
  
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
  
  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return true;
    }
    
    Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
    int prevEnd = intervals[0].end;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < prevEnd) {
        return false;
      }
      prevEnd = intervals[i].end;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    MeetingRooms m = new MeetingRooms();
    Interval[] intervals = {new Interval(0,10), new Interval(25,35), new Interval(10,20)};
    System.out.println(m.canAttendMeetings(intervals));
  }
}