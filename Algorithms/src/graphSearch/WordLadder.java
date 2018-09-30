package graphSearch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
        return 0;
    }

    if (beginWord.equals(endWord)) return 0;
    HashSet<String> wordSet = new HashSet<>();
    for (String str : wordList) {
        wordSet.add(str);
    }
    System.out.println("size of wordSet=" + wordSet.size());
    if (!wordSet.contains(endWord)) return 0;
    
    Deque<String> queue = new LinkedList<>();
    queue.offerFirst(beginWord);
    int count = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        count++;
        System.out.println("cur count=" + count);
        for (int i = 0; i < size; i++) {
            String top = queue.pollLast();
            System.out.println("top string=" + top);
            if (top.equals(endWord)) {
                return count;
            }
         
            for (int j = 0; j < top.length(); j++) {
              char[] chars = top.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[j] == c) continue;
                    chars[j] = c;
                    String str = new String(chars);
                    System.out.println("str=" + str);
                    if (wordSet.contains(str)) {
                        queue.offerFirst(str);
                        wordSet.remove(str);
                    }
                }
            }
        }
    }
    
    return 0;
  }
  
  public static void main(String[] args) {
    WordLadder t = new WordLadder();
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>();
    wordList.add("hot");
    wordList.add("dot");
    wordList.add("dog");
    wordList.add("lot");
    wordList.add("log");
    wordList.add("cog");
    System.out.println(t.ladderLength(beginWord, endWord, wordList));
  }
}