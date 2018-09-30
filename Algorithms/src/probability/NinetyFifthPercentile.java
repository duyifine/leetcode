package probability;

public class NinetyFifthPercentile {
  
  public int get95Percentile(int[] lengths) {
    int[] counter = new int[4100];
    for (int len : lengths) {
      counter[len]++;
    }
    
    double num = 0.05 * 100000;
    int total_so_far = 0;
    for (int i = 4099; i >= 0; i--) {
      total_so_far = total_so_far + counter[i];
      if (total_so_far >= num) {
        return i;
      }
    }
    
    return -1;
  }
}