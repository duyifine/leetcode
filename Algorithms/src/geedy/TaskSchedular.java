package geedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskSchedular {
  
  public int leastInterval(char[] tasks, int n) {
    if (tasks == null || tasks.length == 0) {
      return 0;
    }
    if (n == 0) {
      return tasks.length;
    }
    
    HashMap<Character, Integer> taskCount = new HashMap<Character, Integer>();
    for (char c : tasks) {
      if (!taskCount.containsKey(c)) {
        taskCount.put(c, 1);
      } else {
        taskCount.put(c, taskCount.get(c) + 1);
      }
    }
    
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11, Collections.reverseOrder());
    for (Map.Entry entry : taskCount.entrySet()) {
      queue.offer((int)entry.getValue());
    }
    
    HashMap<Integer, Integer> coolDown = new HashMap<Integer, Integer>();
    int curTime = 0;
    while (!queue.isEmpty() || !coolDown.isEmpty()) {
      if (coolDown.containsKey(curTime - n - 1)) {
        queue.offer(coolDown.remove(curTime - n - 1));
      }
      if (!queue.isEmpty()) {
        int left = queue.poll() - 1;
        if (left != 0) {
          coolDown.put(curTime, left);
        }
      }
      curTime++;
    }
    
    return curTime;
  }
  
  public static void main(String[] args) {
    TaskSchedular t = new TaskSchedular();
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    int n = 2;
    System.out.println(t.leastInterval(tasks, n));
  }
}