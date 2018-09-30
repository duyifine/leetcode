package heapAndGraph;

import java.util.Arrays;

public class Graph {
  
  int V, E;
  Edge edge[];
  Graph(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[E];
    for (int i = 0; i < e; i++) {
      edge[i] = new Edge();
    }
  }
  
  class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int weight;
    
    public int compareTo(Edge compareEdge) {
      return this.weight - compareEdge.weight;
    }
  }
  
  class Subset {
    int parent;
    int rank;
  }
  
  public int find(int[] parent, int i) {
    if (parent[i] == -1) {
      return i;
    }
    return find(parent, parent[i]);
  }
  
  public int find(Subset[] subsets, int i) {
    if (subsets[i].parent != i) {
      subsets[i].parent = find(subsets, subsets[i].parent);
    }
    return subsets[i].parent;
  }
  
  public void union(int[] parent, int x, int y) {
    int xset = find(parent, x);
    int yset = find(parent, y);
    parent[xset] = yset;
  }
  
  public void union(Subset[] subsets, int x, int y) {
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);
    if (subsets[xroot].rank < subsets[yroot].rank) {
      subsets[xroot].parent = yroot;
    } else if (subsets[xroot].rank > subsets[yroot].rank) {
      subsets[yroot].parent = xroot;
    } else {
      subsets[yroot].parent = xroot;
      subsets[xroot].rank++;
    }
  }
  
  public boolean isCycle(Graph graph) {
    int[] parent = new int[graph.V];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = -1;
    }
    
    for (int i = 0; i < graph.E; i++) {
      int x = graph.find(parent, graph.edge[i].src);
      int y = graph.find(parent, graph.edge[i].dest);
      
      if (x == y) {
        return true;
      }
      
      graph.union(parent, x, y);
    }
    return false;
  }
  
  
  public void kruskalMST() {
    Edge[] result = new Edge[V];
    int e = 0;
    for (int i = 0; i < V; i++) {
      result[i] = new Edge();
    }
    
    Arrays.sort(edge);
    
    Subset[] subsets = new Subset[V];
    for (int i = 0; i < V; i++) {
      subsets[i] = new Subset();
    }
    
    for (int v = 0; v < V; v++) {
      subsets[v].parent = v;
      subsets[v].rank = 0;
    }
    
    int i = 0;
    while (e < V - 1) {
      Edge nextEdge = new Edge();
      nextEdge = edge[i++];
      int x = find(subsets, nextEdge.src);
      int y = find(subsets, nextEdge.dest);
      
      if (x != y) {
        result[e++] = nextEdge;
        union(subsets, x, y);
      }
    }
    
    System.out.println("Following are the edges in the MST");
    for (int j = 0; j < e; j++) {
      System.out.println(result[j].src + "--" + result[j].dest + "==" + result[j].weight);
    }
  }
  
  public boolean isCycleII(Graph graph) {
    Subset[] subsets = new Subset[graph.V];
    for (int i = 0; i < subsets.length; i++) {
      subsets[i] = new Subset();
      subsets[i].parent = i;
      subsets[i].rank = 0;
    }
    
    for (int i = 0; i < graph.E; i++) {
      int x = find(subsets, graph.edge[i].src);
      int y = find(subsets, graph.edge[i].dest);
      
      if (x == y) {
        return true;
      }
      
      graph.union(subsets, x, y);
    }
    return false;
  }
  
  public static void main(String[] args) {
    int V = 3;
    int E = 3;
    Graph graph = new Graph(V, E);
    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    graph.edge[1].src = 1;
    graph.edge[1].dest = 2;
    graph.edge[2].src = 0;
    graph.edge[2].dest = 2;
    graph.edge[0].weight = 5;
    graph.edge[1].weight = 3;
    graph.edge[2].weight = 2;
    
    if (graph.isCycle(graph)) {
      System.out.println("graph contains cycle");
    } else {
      System.out.println("graph does not contain cycle");
    }
    
    if (graph.isCycleII(graph)) {
      System.out.println("graph contains cycle");
    } else {
      System.out.println("graph does not contain cycle");
    }
    
    graph.kruskalMST();
  }
}