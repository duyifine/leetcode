package graphSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
  
  public static class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbours;
    public UndirectedGraphNode(int x) {
      label = x;
      neighbours = new ArrayList<>();
    }
  }
  
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return node;
    
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    return dfs(node, map);
  }
  
  public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
    if (node == null) return null;
    if (map.containsKey(node)) {
      return map.get(node);
    }
    
    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    map.put(node, copy);
    for (UndirectedGraphNode neighbour : node.neighbours) {
      copy.neighbours.add(dfs(neighbour, map));
    }
    
    return copy;
  }
}