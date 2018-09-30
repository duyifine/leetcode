package airbnb;

public class CSVParser {
  
  public String parseCSV(String str) {
    if (str == null || str.length() == 0) return "";
    boolean inQuote = false;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (inQuote) {
        if (str.charAt(i) == '\"') {
          if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {
            sb.append('\"');
            i++;
          } else {
            inQuote = false;
          }
        } else {
          sb.append(str.charAt(i));
        }
      } else {
        if (str.charAt(i) == '\"') {
          inQuote = true;
        } else if (str.charAt(i) == ',') {
          sb.append("|");
        } else {
          sb.append(str.charAt(i));
        }
      }
    }
    
    return sb.toString();
  }
  
  public static void main(String[] args) {
    CSVParser sol = new CSVParser();
    String str = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
    System.out.println(sol.parseCSV(str));
    str = "John,Smith,john.smith@gmail.com,Los Angeles,1";
    System.out.println(sol.parseCSV(str));
    str = "\"Alexandra \"\"Alex\"\"\"|Menendez|alex.menendez@gmail.com|Miami|1 \"\"\"Alexandra Alex\"\"\"";
    System.out.println(sol.parseCSV(str));
  }
}