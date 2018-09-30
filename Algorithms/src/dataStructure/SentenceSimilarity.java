package dataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SentenceSimilarity {
  
  public boolean areSentenceSimilarTwo(String[] word1, String[] word2, String[][] pairs) {
    if (word1 == null || word2 == null || word1.length != word2.length) {
      return false;
    }
    
    HashMap<String, Set<String>> map = new HashMap<>();
    for (int i = 0; i < pairs.length; i++) {
      if (!map.containsKey(pairs[i][0])) {
        map.put(pairs[i][0], new HashSet<String>());
      }
      map.get(pairs[i][0]).add(pairs[i][1]);
      if (!map.containsKey(pairs[i][1])) {
        map.put(pairs[i][1], new HashSet<String>());
      }
      map.get(pairs[i][1]).add(pairs[i][0]);
    }
    
    for (int i = 0; i < word1.length; i++) {
      if (word1[i].equals(word2[i])) {
        continue;
      }
      if (!dfs(word1[i], word2[i], map, new HashSet<String>())) {
        return false;
      }
    }
    
    return true;
  }
  
  public boolean dfs(String word1, String word2, HashMap<String, Set<String>> map, HashSet<String> visited) {
    if (visited.contains(word1)) {
      return false;
    }
    if (!map.containsKey(word1) || !map.containsKey(word2)) {
      return false;
    }
    if (map.get(word1).contains(word2)) {
      return true;
    }
    
    visited.add(word1);
    for (String value : map.get(word1)) {
      if (dfs(value, word2, map, visited)) {
        return true;
      }
    }
    visited.remove(word1);
    
    return false;
  }
  
  public HashMap<String, String> father = new HashMap<>();
  public String find(String word) {
    if (word == father.get(word)) {
      return word;
    }
    father.put(word, find(father.get(word)));
    return father.get(word);
  }
  
  public void union(String word1, String word2) {
    String root1 = find(word1);
    String root2 = find(word2);
    if (root1 != root2) {
      father.put(root2, root1);
    }
  }
  
  public boolean areSentenceSimilarUnionFind(String[] word1, String[] word2, String[][] pairs) {
    if (word1 == null || word2 == null || word1.length != word2.length) {
      return false;
    }
    
    for (int i = 0; i < pairs.length; i++) {
      if (!father.containsKey(pairs[i][0])) {
        father.put(pairs[i][0], pairs[i][0]);
      }
      if (!father.containsKey(pairs[i][1])) {
        father.put(pairs[i][1], pairs[i][1]);
      }
      union(pairs[i][0], pairs[i][1]);
    }
    
    for (int i = 0; i < word1.length; i++) {
      if (word1[i].equals(word2[i])) {
        continue;
      }
      if (find(word1[i]) != find(word2[i])) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    SentenceSimilarity t = new SentenceSimilarity();
    String[] word1 = {"great", "acting", "skills"};
    String[] word2 = {"fine", "drama", "talent"};
    String[][] pairs = {{"great", "good"}, {"fine", "good"}, {"acting", "drama"}, {"skills", "talent"}};
    System.out.println(t.areSentenceSimilarTwo(word1, word2, pairs));
    System.out.println(t.areSentenceSimilarUnionFind(word1, word2, pairs));
  }
}