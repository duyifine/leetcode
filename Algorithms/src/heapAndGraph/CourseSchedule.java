package heapAndGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
  
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
        return true;
    }
    
    List<Integer>[] graph = new ArrayList[numCourses];
    int[] indegrees = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < prerequisites.length; i++) {
        graph[prerequisites[i][1]].add(prerequisites[i][0]);
        indegrees[prerequisites[i][0]]++;
    }
    
    Deque<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegrees.length; i++) {
        if (indegrees[i] == 0) {
            queue.offerFirst(i);
        }
    }
    
    int count = 0;
    while (!queue.isEmpty()) {
        int course = queue.pollLast();
        System.out.println("course taken: " + course);
        count++;
        for (int i = 0; i < graph[course].size(); i++) {
            int ready = (int) graph[course].get(i);
            System.out.println("course ready: "+ ready);
            indegrees[ready]--;
            if (indegrees[ready] == 0) {
                queue.offerFirst(ready);
                System.out.println("course put into queue: " + ready);
            }
        }
    }
    
    if (count != numCourses) {
        return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    CourseSchedule c = new CourseSchedule();
    int numCourses = 3;
    int[][] prerequisites = {{1, 0}, {2, 0}};
    System.out.println(c.canFinish(numCourses, prerequisites));
  }
}