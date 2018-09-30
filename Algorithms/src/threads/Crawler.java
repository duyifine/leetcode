package threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Crawler implements Runnable {
  private final String url;
  private final ExecutorService executor;
  private final Map<String, SeenUrl> seenUrls;
  
  public Crawler(String url, ExecutorService executor, Map<String, SeenUrl> seenUrls) {
    this.url = url;
    this.executor = executor;
    this.seenUrls = seenUrls;
  }
  
  public static class SeenUrl {
    public String url;
    public int timeSeen;
    
    public SeenUrl(String url) {
      this.url = url;
      this.timeSeen = 1;
    }
  }

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    // TODO Auto-generated method stub
    List<String> newUrls = parse();
    for (String newUrl : newUrls) {
      synchronized(seenUrls) {
        if (seenUrls.containsKey(newUrl)) {
          seenUrls.get(newUrl).timeSeen++;
        } else {
          seenUrls.put(newUrl, new SeenUrl(newUrl));
          //TODO: Add newUrl to the blocking queue
          executor.submit(new Crawler(newUrl, executor, seenUrls));
        }
      }
    }
  }
  
  public List<String> parse() {
    //TODO
    return new ArrayList<>();
  }
  
  
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Map<String, SeenUrl> seenUrls = new HashMap<>();
    String startUrl = "http://google.com";
    seenUrls.put(startUrl, new SeenUrl(startUrl));
    executorService.submit(new Crawler(startUrl, executorService, seenUrls));
    executorService.awaitTermination(1000, TimeUnit.MINUTES);
  }
}