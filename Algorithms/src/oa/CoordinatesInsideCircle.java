package oa;

public class CoordinatesInsideCircle {
  
  public int numOfCoordinates(int r) {
    if (r <= 0) {
      return 0;
    }
    
    int result = 5;
    for (int x = 1; x < r; x++) {
      int ySquare = r * r - x * x;
      int y = (int) Math.sqrt(ySquare);
      result = result + (y + 1) * 4;
    }
    return result;
  }
  
  public static void main(String[] args) {
    CoordinatesInsideCircle t = new CoordinatesInsideCircle();
    System.out.println(t.numOfCoordinates(1));
    System.out.println(t.numOfCoordinates(5));
  }
}