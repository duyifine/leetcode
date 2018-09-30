package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Wizards {
  
  public int minCosts(List<List<Integer>> wizardList) {
    if (wizardList == null || wizardList.size() == 0) return -1;
    
    HashSet<Integer> visited = new HashSet<>();
    //int[0]: wizard number int[1]: costs from wizard 0 to this wizard
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(11, (i1, i2) -> (i1[1] - i2[1]));
    for (int wizard : wizardList.get(0)) {
      minHeap.offer(new int[] {wizard, wizard * wizard});
    }
    
    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      visited.add(top[0]);
      if (top[0] == 9) return top[1];
      for (int wizard : wizardList.get(top[0])) {
        if (!visited.contains(wizard)) {
          minHeap.offer(new int[] {wizard, top[1] + (wizard - top[0]) * (wizard - top[0])});
        }
      }
    }
    
    return -1;
  }
  
  public static void main(String[] args) {
    Wizards sol = new Wizards();
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(1, 4, 9));
    list.add(Arrays.asList(2));
    list.add(Arrays.asList(3));
    list.add(Arrays.asList(2));
    list.add(Arrays.asList(5));
    list.add(Arrays.asList(6));
    list.add(Arrays.asList(7));
    list.add(Arrays.asList(8));
    list.add(Arrays.asList(9));
    System.out.println(sol.minCosts(list));
  }
}