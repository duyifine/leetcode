package airbnb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GuessNumber {
  private final static String host = "localhost";
  private final static int port = 81;
  
  public static void main(String[] args) throws UnknownHostException, IOException {
    System.out.println("Creating socket to " + host + " on port " + port);
    
    String base = "0000";
    char[] result = new char[4];
    
    boolean notFound = true;
//    while (notFound) {
      Socket socket = new Socket(host, port);
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      
      out.println(base);
      
      String input = br.readLine();
      int first = Integer.parseInt(input.split(" ")[0]);
      if (first == 4) {
        socket.close();
        System.out.println(base);
//        break;
      }
      for (int i = 0; i < 4; i++) {
        int lastResponse = first;
        char[] chBase = base.toCharArray();
        for (char c = '1'; c < '9'; c++) {
          chBase[i] = c;
          out.println(String.valueOf(chBase));
          input = br.readLine();
          int response = Integer.parseInt(input.split(" ")[0]);
          if (response == 4) {
            socket.close();
            System.out.println(String.valueOf(chBase));
            notFound = false;
            break;
          }
          if (response != lastResponse) {
            if (response > lastResponse) {
              result[i] = c;
              first = response;
              base = String.valueOf(chBase);
            } else {
              result[i] = '0';
              first = lastResponse;
              chBase[i] = '0';
              base = String.valueOf(chBase);
            }
            break;
          }
        }
        if (notFound && result[i] == '\u0000') {
          chBase[i] = '9';
          first++;
          if (first == 4) {
            socket.close();
            System.out.println(String.valueOf(chBase));
            notFound = false;
            break;
          }
          base = String.valueOf(chBase);
        }
      }
//    }
  }
}