package string;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class NumOfMatchingSubsequence {
  public int numMatchingSubseq(String S, String[] words) {
    if (S == null || S.length() == 0 || words == null || words.length == 0) {
        return 0;
    }
    
    HashMap<Character, Deque<String>> map = new HashMap<>();
    for (char c = 'a'; c <= 'z'; c++) {
        map.put(c, new LinkedList<>());
    }
    
    for (int i = 0; i < words.length; i++) {
        map.get(words[i].charAt(0)).offerFirst(words[i]);
    }
    
    int count = 0;
    for (int i = 0; i < S.length(); i++) {
        Deque<String> list = map.get(S.charAt(i));
        int size = list.size();
        System.out.println("size=" + size);
        for (int j = 0; j < size; j++) {
            String curWord = list.pollLast();
            System.out.println("cur word =" + curWord);
            if (curWord.length() == 1) {
              System.out.println("cur length = 1" + curWord);
                count++;
            } else {
              System.out.println("push substring: " + curWord.substring(1));
                map.get(curWord.charAt(1)).offerFirst(curWord.substring(1));
            }
        }
    }
    
    return count;
  }
  
  public static void main(String[] args) {
    NumOfMatchingSubsequence t = new NumOfMatchingSubsequence();
    String S= "abcde";
    String[] words = {"a", "bb","acd", "ace"};
    System.out.println(t.numMatchingSubseq(S, words));
  }
}