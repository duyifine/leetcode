package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
  
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    if (words == null || words.length == 0) return result;
    
    HashMap<String, Integer> map = new HashMap<>();
    int i = 0;
    for (String word : words) {
      map.put(word, i++);
    }
    
    if (map.containsKey("")) {
      int index = map.get("");
      for (int j = 0; j < words.length; j++) {
        if (isPalindrome(words[j])) {
          if (j == index) continue;
          result.add(Arrays.asList(index, j));
          result.add(Arrays.asList(j, index));
        }
      }
    }
    
    for (int j = 0; j < words.length; j++) {
      String reverse = reverseString(words[j]);
      if (map.containsKey(reverse)) {
        if (map.get(reverse) != j) {
          result.add(Arrays.asList(j, map.get(reverse)));
        }
      }
    }
    
    for (int j = 0; j < words.length; j++) {
      String word = words[j];
      for (int cut = 1; cut < word.length(); cut++) {
        if (isPalindrome(word.substring(0, cut))) {
          String rev = reverseString(word.substring(cut));
          if (map.containsKey(rev)) {
            result.add(Arrays.asList(map.get(rev), j));
          }
        }
        if (isPalindrome(word.substring(cut))) {
          String rev = reverseString(word.substring(0, cut));
          if (map.containsKey(rev)) {
            result.add(Arrays.asList(j, map.get(rev)));
          }
        }
      }
    }
    
    return result;
  }
  
  public String reverseString(String s) {
    char[] array = s.toCharArray();
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      char tmp = array[left];
      array[left] = array[right];
      array[right] = tmp;
      left++;
      right--;
    }
    
    return String.valueOf(array);
  }
  
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    PalindromePairs sol = new PalindromePairs();
    String[] words = {"abcd","dcba","lls","s","sssll"};
    System.out.println(sol.palindromePairs(words));
  }
}