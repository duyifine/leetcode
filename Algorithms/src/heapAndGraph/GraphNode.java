package heapAndGraph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  public int label;
  public List<GraphNode> neighbours;
  public GraphNode(int x) {
    label = x;
    neighbours = new ArrayList<GraphNode>();
  }
}