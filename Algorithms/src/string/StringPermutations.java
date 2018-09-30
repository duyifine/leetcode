package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringPermutations {
  
  
  public List<String> permuteWithoutDuplicate(String s) {
    List<String> result = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return result;
    }
    
    char[] array = s.toCharArray();
    
    helper(array, 0, result);
    return result;
  }
  
  public void helper(char[] array, int index, List<String> result) {
    if (index == array.length) {
      result.add(new String(array));
      return;
    }
    
    for (int i = index; i < array.length; i++) {
      swap(array, i, index);
      helper(array, index + 1, result);
      swap(array, i, index);
    }
  }
  
  public void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  
  public List<String> permuteWithDuplicate(String s) {
    List<String> result = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return result;
    }
    
    char[] array = s.toCharArray();
    helper2(array, 0, result);
    return result;
  }
  
  public void helper2(char[] array, int index, List<String> result) {
    if (index == array.length) {
      result.add(new String(array));
      return;
    }
    
    HashSet<Character> set = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (!set.contains(array[i])) {
        set.add(array[i]);
        swap(array, i, index);
        helper(array, index + 1, result);
        swap(array, i, index);
      } 
    }
  }
  
  public static void main(String[] args) {
    String s1 = "abs";
    StringPermutations t = new StringPermutations();
    System.out.println(t.permuteWithoutDuplicate(s1));
    String s2 = "abha";
    System.out.println(t.permuteWithDuplicate(s2));
  }
}