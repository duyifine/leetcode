package airbnb;

import java.util.Map;
import java.util.TreeMap;

public class FileSystem {
  
  Map<String, Integer> pathMap;
  Map<String, Runnable> callBackMap;
  
  public FileSystem() {
    this.pathMap = new TreeMap<>();
    this.callBackMap = new TreeMap<>();
    this.pathMap.put("", 0);
  }
  
  public boolean create(String path,int value) {
    if (pathMap.containsKey(path)) {
      return false;
    }
    
    int lastSlash = path.lastIndexOf("/");
    if (!pathMap.containsKey(path.substring(0, lastSlash))) {
      return false;
    }
    pathMap.put(path, value);
    return true;
  }
  
  public Integer get(String path) {
    return pathMap.get(path);
  }
  
  public boolean set(String path, int value) {
    if (pathMap.containsKey(path)) {
      return false;
    }
    
    pathMap.put(path, value);
    
    String cur = path;
    while (cur.length() > 0) {
      if (callBackMap.containsKey(cur)) {
        callBackMap.get(cur).run();
      }
      int lastSlash = cur.lastIndexOf("/");
      cur = cur.substring(0, lastSlash);
    }
    
    return true;
  }
  
  public boolean watch(String path, Runnable callback) {
    if (!pathMap.containsKey(path)) {
      return false;
    }
    callBackMap.put(path, callback);
    return true;
  }
  
  public static void main(String[] args) {
    FileSystem f = new FileSystem();
    System.out.println(f.create("/a", 1));
    System.out.println(f.get("/a"));
    f.watch("/a", new Runnable() {
      @Override
      public void run() {
        // TODO Auto-generated method stub
        System.out.println("got it!");
      }
    });
    System.out.println(f.set("/a/b", 3));
    System.out.println(f.set("/c", 2));
    System.out.println(f.set("/a/c/d", 4));
    System.out.println(f.set("/a/c", 4));
    System.out.println(f.set("/a/b/d", 3));
  }
}