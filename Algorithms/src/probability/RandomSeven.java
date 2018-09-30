package probability;

public class RandomSeven {
  
  public int random5() {
    return (int) (Math.random() * 5);
  }
  
  public int random7() {
    while (true) {
      int random = 5 * random5() + random5();
      if (random < 21) {
        return random % 7;
      }
    }
  }
  
  public static void main(String[] args) {
    RandomSeven s = new RandomSeven();
    for (int i = 0; i < 7; i++) {
      System.out.println(s.random7());
    }
  }
}