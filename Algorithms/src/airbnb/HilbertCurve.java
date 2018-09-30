package airbnb;

public class HilbertCurve {
  
  public int indexInHilbertCurve(int x, int y, int iter) {
    if (iter == 0) return 1;
    int offset = 1 << (iter - 1);
    int unitSteps = 1 << ((iter - 1) * 2);
    
    if (x >= offset && y >= offset) {
      return 2 * unitSteps + indexInHilbertCurve(x - offset, y - offset, iter - 1);
    } else if (x >= offset && y < offset) {
      return 3 * unitSteps + indexInHilbertCurve(offset - 1 - y, 2 * offset - 1 - x, iter - 1);
    } else if (x < offset && y >= offset) {
      return unitSteps + indexInHilbertCurve(x, y - offset, iter - 1);
    } else {
      return indexInHilbertCurve(y, x, iter - 1);
    }
  }
  
  public static void main(String[] args) {
    HilbertCurve s = new HilbertCurve();
    System.out.println(s.indexInHilbertCurve(1, 1, 2));
    System.out.println(s.indexInHilbertCurve(0, 1, 1));
    System.out.println(s.indexInHilbertCurve(2, 2, 2));
  }
}