package graphSearch;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
  
  public int getSequence(List<Integer> list) {
    if (list == null || list.size() == 0) {
      return 0;
    }
    
    int result = 1;
    List<Integer> firstSeq = new ArrayList<>();
    for (int i = 1; i <= list.size(); i++) {
      firstSeq.add(i);
    }
    int index = 0;
    while (index < list.size()) {
      int cur = list.get(index);
      if (firstSeq.indexOf(cur) > 0) {
        result = result + (firstSeq.indexOf(cur)) * factorial(list.size() - 1);
        System.out.println("cur result=" + result);
        firstSeq.remove(list.get(index));
        list.remove(index);
      } else {
        index++;
      }
    }
    
    return result;
  }
  
  public String getPermutation(int n, int k) {
    if (n <= 0 || k <= 0) return "";
    
    StringBuilder sb = new StringBuilder();
    int[] factorial = new int[n];
    factorial[0] = 1;
    for (int i = 1; i < n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }
    
    List<Integer> nums = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }
    
    k = k - 1;
    for (int i = n; i >= 1; i--) {
      int index = k / factorial[i - 1];
      k = k % factorial[i - 1];
      sb.append(nums.get(index));
      nums.remove(index);
    }
    
    return sb.toString();
  }
  
  public int factorial(int n) {
    int result = 1;
    for (int i = n; i >= 1; i--) {
      result = result * i;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    PermutationSequence t = new PermutationSequence();
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(1);
    System.out.println(t.getSequence(list));
  }
}