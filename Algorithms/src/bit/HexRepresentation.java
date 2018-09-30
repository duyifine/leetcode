package bit;

public class HexRepresentation {
  
  public String toHex(int num) {
    if (num == 0) {
      return new String("0x0");
    }
    
    StringBuilder result = new StringBuilder();
    char[] base = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    while (num != 0) {
      int remainder = num % 16;
      num = num / 16;
      result.insert(0, base[remainder]);
    }
    result.insert(0, "0x");
    
    return result.toString();
  }
  
  public static void main(String[] args) {
    int num = 66;
    HexRepresentation h = new HexRepresentation();
    System.out.println(h.toHex(num));
  }
}