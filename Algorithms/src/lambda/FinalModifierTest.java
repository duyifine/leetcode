package lambda;

public class FinalModifierTest {
  final int[] array;
  
  public FinalModifierTest(int[] array) {
    this.array = array;
  }
  
  public void setString(String s) {
    s = s + "copy";
  }
  
  public void setInt(int i) {
    i = i + 1;
  }
  
  public static void main(String[] args) {
    int[] array = {1,2,3};
    FinalModifierTest f = new FinalModifierTest(array);
    array[0] = 2;
    for (int i = 0; i < f.array.length; i++) {
      System.out.println(f.array[i]);
    }
    
    String s = "abc";
    f.setString(s);
    System.out.println(s);
    
    int i = 0;
    f.setInt(i);
    System.out.println(i);
  }
}