package airbnb;

import java.util.HashSet;

public class LetterGuess {
  
  public static String sendAndReceive(String str) {
    return "";
  }
  
  public static String guess() {
    HashSet<Character> inResult = new HashSet<>();
    String base = "aaaaa";
    int first = Integer.parseInt(sendAndReceive(base).split(" ")[0]);
    if (first == 5) return base;
    char[] result = new char[5];
    
    for (int i = 0; i < 5; i++) {
      int lastResponse = first;
      char[] chBase = base.toCharArray();
      for (char c = 'b'; c < 'z'; c++) {
        if (inResult.contains(c)) continue;
        chBase[i] = c;
        int response = Integer.parseInt(sendAndReceive(chBase.toString()).split(" ")[0]);
        if (response == 5) return String.valueOf(chBase);
        if (response != lastResponse) {
          if (response > lastResponse) {
            result[i] = c;
          } else {
            result[i] = 'a';
          }
          inResult.add(result[i]);
          break;
        }
      }
      if (result[i] == '\u0000') {
        result[i] = 'z';
        inResult.add('z');
      }
    }
    
    return new String(result);
  }
}