package string;

import java.util.Deque;
import java.util.LinkedList;

public class Deduplication {
  
  public String deduplicate(String input) {
    if (input == null || input.length() == 0) {
      return null;
    }
    
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 1;
    while (fast < array.length) {
      while (fast < array.length && array[fast] == array[slow]) {
        fast++;
      }
      if (fast == array.length) break;
      if (fast < array.length) {
        slow++;
        array[slow] = array[fast++];
      }
    }
    return new String(array, 0, slow + 1);
  }
  
  public String removeAllAdjcentDuplication(String input) {
    if (input == null || input.length() == 0) {
      return null;
    }
    
    Deque<Character> stack = new LinkedList<Character>();
    int index = 0;
    char[] array = input.toCharArray();
    while (index < array.length) {
      if (!stack.isEmpty() && array[index] == stack.peekFirst()) {
        while (index < array.length && array[index] == stack.peekFirst()) {
          index++;
        }
        stack.pollFirst();
      } else {
        stack.offerFirst(array[index]);
        index++;
      }
    }
    int length = stack.size();
    for (int i = length - 1; i >= 0; i--) {
      array[i] = stack.pollFirst();
    }
    return new String(array, 0, length);
  }
  
  public static void main(String[] args) {
    String input = "abbbbazw";
    Deduplication d = new Deduplication();
    System.out.println(d.removeAllAdjcentDuplication(input));
  }
}