package heapAndGraph;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Bipartite {
  
  public boolean isBipartite(List<GraphNode> graph) {
    if (graph == null) {
      return true;
    }
     
    HashMap<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
    for (GraphNode  node : graph) {
      if (!BFS(node, map)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean BFS(GraphNode node, HashMap<GraphNode, Integer> map) {
    if (map.containsKey(node)) {
      return true;
    }
    
    Deque<GraphNode> queue = new LinkedList<GraphNode>();
    queue.offerFirst(node);
    while (!queue.isEmpty()) {
      GraphNode top = queue.pollLast();
      int topSign = map.get(top);
      for (GraphNode neighbour : top.neighbours) {
        if (map.get(neighbour) == topSign) {
          return false;
        } else if (!map.containsKey(neighbour)) {
          map.put(neighbour, 1 - topSign);
        }
      }
    }
    return true;
  }
}