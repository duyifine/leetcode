package dataStructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] result = new int[numCourses];
    if (numCourses == 0 || prerequisites == null) {
      return result;
    }
    
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] indegrees = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      if (!map.containsKey(prerequisites[i][1])) {
        map.put(prerequisites[i][1], new ArrayList<>());
      }
      map.get(prerequisites[i][1]).add(prerequisites[i][0]);
      indegrees[prerequisites[i][0]]++;
    }
    
    Deque<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegrees.length; i++) {
      if (indegrees[i] == 0) {
        queue.offerFirst(i);
      }
    }
    
    int index = 0;
    int count = 0;
    while (!queue.isEmpty()) {
      int course = queue.pollLast();
      result[index++] = course;
      count++;
      List<Integer> nodes = map.get(course);
      if (nodes != null) {
        for (int node : nodes) {
          indegrees[node]--;
          if (indegrees[node] == 0) {
            queue.offerFirst(node);
          }
        }
      }
    }
    
    if (count == numCourses) {
      return result;
    }
    return new int[0];
  }
}