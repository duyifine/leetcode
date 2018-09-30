package airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
  
  public List<String> fullyJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0 || maxWidth <= 0) return result;
    
    int curLen = 0;
    int start = 0;
    for (int i = 0; i < words.length; i++) {
      curLen = curLen + words[i].length() + 1;
      if (curLen - 1 > maxWidth) {
        justifyLine(words, maxWidth, result, start, i - 1);
        start = i;
        curLen = words[i].length() + 1;
      }
    }
    justifyLine(words, maxWidth, result, start, words.length - 1);
    
    return result;
  }
  
  public void justifyLine(String[] words, int maxWidth, List<String> result, int start, int end) {
    StringBuilder sb = new StringBuilder();
    if (start == end) {
      sb.append(words[start]);
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }
      result.add(sb.toString());
    } else if (end == words.length - 1) {
      for (int i = start; i < end; i++) {
        sb.append(words[i]);
        sb.append(" ");
      }
      sb.append(words[end]);
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }
      result.add(sb.toString());
    } else {
      for (int i = start; i <= end; i++) {
        maxWidth = maxWidth - words[i].length();
      }
      while (maxWidth > 0) {
        for (int i = start; i < end; i++) {
          words[i] = words[i] + " ";
          maxWidth--;
          if (maxWidth == 0) break;
        }
      }
      for (int i = start; i <= end; i++) {
        sb.append(words[i]);
      }
      result.add(sb.toString());
    }
  }
  
  public static void main(String[] args) {
    TextJustification sol = new TextJustification();
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    System.out.println(sol.fullyJustify(words, 16));
    String[] words2 = {"What","must","be","acknowledgment","shall","be"};
    System.out.println(sol.fullyJustify(words2, 16));
  }
}