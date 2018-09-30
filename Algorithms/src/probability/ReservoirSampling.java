package probability;

public class ReservoirSampling {
  
  private int count;
  private Integer sample;
  
  public ReservoirSampling() {
    this.count = 0;
    this.sample = null;
  }
  
  public void read(int value) {
    count++;
    int r = (int) Math.random() * count;
    if (r == 0) sample = value;
  }
  
  public Integer sample() {
    return this.sample;
  }
}