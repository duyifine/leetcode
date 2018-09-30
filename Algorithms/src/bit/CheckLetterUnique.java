package bit;

public class CheckLetterUnique {
  
  public boolean isUnique(String input) {
    if (input == null || input.length() == 0) {
      return true;
    }
    
    int[] mask = new int[8];
    for (int i = 0; i < input.length(); i++) {
      int mask_index1 = input.charAt(i) / 32;
      int mask_index2 = input.charAt(i) % 32;
      
      if (((mask[mask_index1] >> mask_index2) & 1) == 1) {
        return false;
      } else {
        mask[mask_index1] = mask[mask_index1] | 1 << mask_index2;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    String input = "power";
    CheckLetterUnique c = new CheckLetterUnique();
    System.out.println(c.isUnique(input));
  }
}