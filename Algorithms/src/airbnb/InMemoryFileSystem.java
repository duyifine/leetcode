package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class InMemoryFileSystem {
  HashMap<String, TreeSet<String>> dirs;
  HashMap<String, List<String>> files;
  String root = "/";
  
  public InMemoryFileSystem() {
    dirs = new HashMap<>();
    files = new HashMap<>();
    dirs.put(root, new TreeSet<>());
  }
  
  public List<String> ls(String path) {
    List<String> result = new ArrayList<>();
    if (dirs.containsKey(path)) {
        result.addAll(dirs.get(path));
        return result;
    }
    if (files.containsKey(path)) {
        result.add(path.substring(path.lastIndexOf("/") + 1));
        return result;
    }
    return result;
  }
  
  public void mkdir(String path) {
    String[] elements = path.split("/");
    String start = "";
    int index = 0;
    while (index < elements.length - 1) {
      TreeSet<String> children = null;
      if (index == 0) {
        children = dirs.get(root);
      } else {
        if (!dirs.containsKey(start)) {
          dirs.put(start, new TreeSet<>());
        }
        children = dirs.get(start);
      }
      children.add(elements[index + 1]);
      start = start + "/" + elements[index + 1];
      index++;
    }
  }
  
  public void addContentToFile(String filePath, String content) {
    mkdir(filePath);
    if (!files.containsKey(filePath)) {
        files.put(filePath, new ArrayList<>());
    }
    files.get(filePath).add(content);
  }

  public String readContentFromFile(String filePath) {
    StringBuilder sb = new StringBuilder();
    if (files.containsKey(filePath)) {
        for (String str : files.get(filePath)) {
            sb.append(str);
        }
    }
    
    return sb.toString();
  }
}