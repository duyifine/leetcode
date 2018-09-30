package array;

import java.util.LinkedList;

public class ReadNChars {
  
  public int read(char[] buf, int n) {
    int count = 0;
    char[] mybuf = new char[4];
    while (count < n) {
      int num = read4(mybuf);
      if (num == 0) break;
      int index = 0;
      while (index < num && count < n) {
        buf[index++] = mybuf[index++];
      }
    }
    return count;
  }
  
  LinkedList<Character> buff = new LinkedList<Character>();
  public int readII(char[] buf, int n) {
    int total = 0;
    while (true) {
      char[] tmp = new char[4];
      int num = read4(tmp);
      for (int i = 0; i < num; i++) {
        buff.add(tmp[i]);
      }
      
      int left = Math.min(buff.size(), n - total);
      for (int i = 0; i < left; i++) {
        buf[total++] = buff.poll();
      }
      if (left == 0) break;
    }
    return total;
  }
  
  public int read4(char[] buf) {
    buf = new char[4];
    return 4;
  }
}