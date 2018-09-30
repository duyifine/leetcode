package heapAndGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GraphPath {
  public List<String> graphPaths(GraphNode node) {
    List<String> result = new ArrayList<String>();
    if (node == null) {
      return result;
    }
    
    HashSet<GraphNode> visited = new HashSet<GraphNode>();
    String str = "";
    dfs(node, visited, str, result);
    return result;
  }
  
  public void dfs(GraphNode node, HashSet<GraphNode> visited, String str, List<String> result) {
    if (node == null) {
      return;
    }
    if (visited.contains(node)) {
      return;
    }
    if (node.neighbours.size() == 0) {
      str = str + node.label;
      result.add(str);
      return;
    }
    
    visited.add(node);
    str = str + node.label + "->";
    for (GraphNode nei : node.neighbours) {
      dfs(nei, visited, str, result);
    }
    visited.remove(node);
  }
  
  public static void main(String[] args) {
    GraphPath g = new GraphPath();
    GraphNode node1 = new GraphNode(1);
    GraphNode node2 = new GraphNode(2);
    GraphNode node3 = new GraphNode(3);
    GraphNode node4 = new GraphNode(5);
    GraphNode node5 = new GraphNode(6);
    node1.neighbours.add(node2);
    node1.neighbours.add(node3);
    node2.neighbours.add(node4);
    node4.neighbours.add(node3);
    node3.neighbours.add(node2);
    node3.neighbours.add(node5);
    System.out.println(g.graphPaths(node1));
  }
}