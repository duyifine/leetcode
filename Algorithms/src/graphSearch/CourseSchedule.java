package graphSearch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null) return new int[0];
    
    int[][] matrix = new int[numCourses][numCourses];
    int[] indegrees = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
      indegrees[prerequisites[i][0]]++;
    }
    
    Deque<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegrees.length; i++) {
      if (indegrees[i] == 0) {
        queue.offerFirst(i);
      }
    }
    
    int[] result = new int[numCourses];
    int count = 0;
    int index = 0;
    while (!queue.isEmpty()) {
      int course = queue.pollLast();
      result[index++] = course;
      count++;
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[course][i] == 1) {
          indegrees[i]--;
          if (indegrees[i] == 0) queue.offerFirst(i);
        }
      }
    }
    
    if (count != numCourses) return new int[0];
    return result;
  }
  
  public int[] findOrderII(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null) return new int[0];
    
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
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
      if (indegrees[i] == 0) queue.offerFirst(i);
    }
    
    int[] result = new int[numCourses];
    int count = 0;
    int index = 0;
    while (!queue.isEmpty()) {
      int course = queue.pollLast();
      count++;
      result[index++] = course;
      List<Integer> outdegrees = map.get(course);
      for (int o : outdegrees) {
        indegrees[o]--;
        if (indegrees[o] == 0) queue.offerFirst(o);
      }
    }
    
    if (count == numCourses) return result;
    
    return new int[0];
  }
}