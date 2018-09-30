package dataStructure;

public class HitCounter {
  
  int[] hits;
  int[] timestamps;
  public HitCounter() {
    hits = new int[300];
    timestamps = new int[300];
  }
  
  public void hit(int timestamp) {
    int index = timestamp % 300;
    if (timestamps[index] == timestamp) {
      hits[index]++;
    } else {
      timestamps[index] = timestamp;
      hits[index] = 1;
    }
  }
  
  public int getHits(int timestamp) {
    int result = 0;
    for (int i = 0; i < 300; i++) {
      if (timestamps[i] < timestamp) {
        result = result + hits[i];
      }
    }
    return result;
  }
}