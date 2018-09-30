package airbnb;

import java.util.ArrayList;
import java.util.List;

public class CaseCombinations {
  
  public List<String> findCaseCombinations(String text) {
    List<String> result = new ArrayList<>();
    if (text == null || text.length() == 0) return result;
    
    List<String> combos = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    combinations(text, 0, combos, sb);
    
    for (String str : combos) {
      char[] array = str.toCharArray();
      permutations(array, 0, result);
    }
    
    return result;
  }
  
  public void combinations(String text, int index, List<String> result, StringBuilder sb) {
    if (index == text.length() && sb.length() == text.length()) {
      result.add(sb.toString());
      return;
    }
    
    for (int i = index; i < text.length(); i++) {
      sb.append(Character.toLowerCase(text.charAt(i)));
      combinations(text, i + 1, result, sb);
      sb.deleteCharAt(sb.length() - 1);
      sb.append(Character.toUpperCase(text.charAt(i)));
      combinations(text, i + 1, result, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
  
  public void permutations(char[] array, int index, List<String> result) {
    if (index == array.length) {
      result.add(new String(array));
      return;
    }
    
    for (int i = index; i < array.length; i++) {
      swap(array, i, index);
      permutations(array, index + 1, result);
      swap(array, i, index);
    }
  }
  
  public void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  
  public static void main(String[] args) {
    CaseCombinations sol = new CaseCombinations();
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    sol.combinations("airbnb", 0, result, sb);
    System.out.println(result.size());
    System.out.println(sol.findCaseCombinations("ab"));
  }
}