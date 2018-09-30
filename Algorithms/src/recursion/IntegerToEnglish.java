package recursion;

public class IntegerToEnglish {
  private final static String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
      "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Forteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final static String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
  
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    
    String result = "";
    int i = 0;
    while (num != 0) {
      if (num % 1000 != 0) {
        result = helper(num % 1000) + THOUSANDS[i] + " " + result;
      }
      num = num / 1000;
      i++;
    }
    
    return result.trim();
  }
  
  public String helper(int num) {
    if (num == 0) {
      return "";
    } else if (num < 20) {
      return LESS_THAN_TWENTY[num] + " ";
    } else if (num < 100) {
      return TENS[num / 10] + " " + helper(num % 10);
    } else {
      return LESS_THAN_TWENTY[num / 100] + " Hundred" + " " + helper(num % 100);
    }
  }
  
  public static void main(String[] args) {
    IntegerToEnglish t = new IntegerToEnglish();
    int num = 1234567;
    System.out.println(t.numberToWords(num));
  }
}