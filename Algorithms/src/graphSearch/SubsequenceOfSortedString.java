package graphSearch;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfSortedString {
  
  public List<List<Character>> subsequence(String set) {
    List<List<Character>> result = new ArrayList<List<Character>>();
    if (set == null || set.length() == 0) {
      return result;
    }
    
    List<Character> subList = new ArrayList<Character>();
    char[] array = set.toCharArray();
    helper(array, 0, result, subList);
    return result;
  }
  
  public void helper(char[] array, int index, List<List<Character>> result, List<Character> tmpList) {
    if (index >= array.length) {
      result.add(new ArrayList<Character>(tmpList));
      return;
    }
    
    tmpList.add(array[index]);
    helper(array, index + 1, result, tmpList);
    tmpList.remove(tmpList.size() - 1);
    
    while (index < array.length - 1 && array[index] == array[index + 1]) {
      index++;
    }
    helper(array, index + 1, result, tmpList);
  }
  
  public static void main(String[] args) {
    String set = "abbbc";
    SubsequenceOfSortedString s = new SubsequenceOfSortedString();
    System.out.println(s.subsequence(set));
  }
}