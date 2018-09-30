package heapAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CopyGraph {
  static class GraphNode {
    int label;
    List<GraphNode> neighbours;
    public GraphNode(int x) {
      this.label = x;
      neighbours = new ArrayList<GraphNode>();
    }
  }
  
  public GraphNode cloneGraph(GraphNode node) {
    if (node == null) {
      return node;
    }
    
    HashMap<GraphNode, GraphNode> map = new HashMap<>();
    return clone(node, map);
  }
  
  public GraphNode clone(GraphNode node, HashMap<GraphNode, GraphNode> map) {
    if (node == null) {
      return null;
    }
    if (map.containsKey(node)) {
      return map.get(node);
    }
    
    GraphNode copy = new GraphNode(node.label);
    map.put(node, copy);
    for (GraphNode nei : node.neighbours) {
      copy.neighbours.add(clone(nei, map));
    }
    return copy;
  }
}