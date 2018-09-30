package airbnb;

import java.util.HashMap;

public class FileSystemII {
  public interface CallBack {
    public void resolve();
  }
  
  public static class CallBackImp implements CallBack {

    /* (non-Javadoc)
     * @see airbnb.FileSystemII.CallBack#resolve()
     */
    @Override
    public void resolve() {
      // TODO Auto-generated method stub
      System.out.println("Found file created.");
    }
    
  }
  
  HashMap<String, Integer> pathMap;
  HashMap<String, CallBack> callBackMap;
  
  public FileSystemII() {
    pathMap = new HashMap<>();
    callBackMap = new HashMap<>();
    pathMap.put("", 0);
  }
  
  public boolean create(String path, int value) {
    if (pathMap.containsKey(path)) {
      if (pathMap.get(path) != value) {
        return false;
      }
      return true;
    }
    
    int lastSlash = path.lastIndexOf("/");
    if (!pathMap.containsKey(path.substring(0, lastSlash))) {
      return false;
    }
    pathMap.put(path, value);
    String curPath = path;
    while (!curPath.isEmpty()) {
      if (callBackMap.containsKey(curPath)) {
        callBackMap.get(curPath).resolve();
      }
      int lastSlashIndex = curPath.lastIndexOf("/");
      curPath = curPath.substring(0, lastSlashIndex);
    }
    return true;
  }
  
  public Integer get(String path) {
    return pathMap.get(path);
  }
  
  public boolean set(String path, int value) {
    if (!pathMap.containsKey(path)) {
      return false;
    }
    pathMap.put(path, value);
    String curPath = path;
    while (!curPath.isEmpty()) {
      if (callBackMap.containsKey(curPath)) {
        callBackMap.get(curPath).resolve();
      }
      int lastSlashIndex = curPath.lastIndexOf("/");
      curPath = curPath.substring(0, lastSlashIndex);
    }
    return true;
  }
  
  public boolean watch(String path, CallBack callBack) {
    callBackMap.put(path, callBack);
    return true;
  }
  
  public static void main(String[] args) {
    FileSystemII f = new FileSystemII();
    CallBackImp callBack = new CallBackImp();
    f.watch("/a", callBack);
    System.out.println(f.create("/a", 1));
    System.out.println(f.get("/a"));
    System.out.println(f.create("/a/b", 2));
//    CallBackImp callBack = new CallBackImp();
//    f.watch("/a", callBack);
    System.out.println(f.set("/a/b", 3));
//    System.out.println(f.set("/c", 2));
//    System.out.println(f.create("/c", 2));
    System.out.println(f.create("/a/b/c", 2));
//    System.out.println(f.set("/a/c/d", 4));
//    System.out.println(f.set("/a/c", 4));
//    System.out.println(f.set("/a/b/d", 3));
  }
}