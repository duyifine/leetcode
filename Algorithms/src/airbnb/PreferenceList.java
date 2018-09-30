package airbnb;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PreferenceList {
  
  public List<Integer> getPreference(List<List<Integer>> preferences) {
    List<Integer> result = new ArrayList<>();
    if (preferences == null || preferences.size() == 0) return result;
    
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    HashMap<Integer, Integer> indegrees = new HashMap<>();
    
    for (List<Integer> preference : preferences) {
      for (int i = 0; i < preference.size() - 1; i++) {
        int from = preference.get(i);
        int to = preference.get(i + 1);
        if (!map.containsKey(from)) {
          map.put(from, new HashSet<>());
          indegrees.put(from, 0);
        }
        if (!map.containsKey(to)) {
          map.put(to, new HashSet<>());
          indegrees.put(to, 0);
        }
        if (!map.get(from).contains(to)) {
          map.get(from).add(to);
          indegrees.put(to, indegrees.get(to) + 1);
        }        
      }
    }
    
    Deque<Integer> queue = new LinkedList<>();
    for (int key : indegrees.keySet()) {
      if (indegrees.get(key) == 0) {
        queue.offerFirst(key);
      }
    }
    
    while (!queue.isEmpty()) {
      int top = queue.pollLast();
      result.add(top);
      if (map.containsKey(top)) {
        for (int next : map.get(top)) {
          indegrees.put(next, indegrees.get(next) - 1);
          if (indegrees.get(next) == 0) {
            queue.offerFirst(next);
          }
        }
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    PreferenceList sol = new PreferenceList();
    List<List<Integer>> preferences = new ArrayList<>();
    List<Integer> p1 = new ArrayList<Integer>() {{
        add(2);
        add(3);
        add(5);
    }};
    List<Integer> p2 = new ArrayList<Integer>() {{
        add(4);
        add(2);
        add(1);
    }};
    List<Integer> p3 = new ArrayList<Integer>() {{
        add(4);
        add(1);
        add(5);
        add(6);
    }};
    List<Integer> p4 = new ArrayList<Integer>() {{
        add(4);
        add(7);
    }};
    preferences.add(p1);
    preferences.add(p2);
    preferences.add(p3);
    preferences.add(p4);
    List<Integer> res = sol.getPreference(preferences);
    System.out.println(res);
    p1 = new ArrayList<Integer>() {{
      add(3);
      add(5);
      add(7);
      add(9);
    }};
    p2 = new ArrayList<Integer>() {{
      add(2);
      add(3);
      add(8);
    }};
    p3 = new ArrayList<Integer>() {{
      add(5);
      add(8);
    }};
    preferences = new ArrayList<>();
    preferences.add(p1);
    preferences.add(p2);
    preferences.add(p3);
    res = sol.getPreference(preferences);
    System.out.println(res);
  }
}