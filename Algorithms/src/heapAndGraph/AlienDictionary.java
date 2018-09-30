package heapAndGraph;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AlienDictionary {
  
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";
    
    HashMap<Character, HashSet<Character>> map = new HashMap<>();
    HashMap<Character, Integer> indegrees = new HashMap<>();
    
    StringBuilder sb = new StringBuilder();
    
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        char cur = word.charAt(i);
        if (!map.containsKey(cur)) {
          map.put(cur, new HashSet<>());
        }
        if (!indegrees.containsKey(cur)) {
          indegrees.put(cur, 0);
        }
      }
    }
    
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      for (int j = 0; j < word1.length() && j < word2.length(); j++) {
        char from = word1.charAt(j);
        char to = word2.charAt(j);
        if (from == to) continue;
        if (!set.contains(from + "" + to)) {
          map.get(from).add(to);
          indegrees.put(to, indegrees.get(to) + 1);
          set.add(from + "" + to);
          break;
        }
      }
    }
    
    Deque<Character> queue = new LinkedList<>();
    for (Character key : map.keySet()) {
      if (indegrees.get(key) == 0) {
        queue.offerFirst(key);
      }
    }
    
    while (!queue.isEmpty()) {
      Character top = queue.pollLast();
      sb.append(top);
      HashSet<Character> outdegrees = map.get(top);
      for (Character c : outdegrees) {
        int val = indegrees.get(c);
        val--;
        indegrees.put(c, val);;
        if (val == 0) {
          queue.offerFirst(c);
        }
      }
    }
    
    if (sb.length() == indegrees.size()) return sb.toString();
    
    return "";
  }
}