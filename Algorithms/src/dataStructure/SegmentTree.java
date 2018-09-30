package dataStructure;

public class SegmentTree {
  
  public static class SegmentTreeNode {
    public int start;
    public int end;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      this.left = null;
      this.right = null;
    }
  }
  
  public SegmentTreeNode build(int start, int end) {
    if (start > end) {
      return null;
    }
    
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    
    if (start != end) {
      int mid = start + (end - start) / 2;
      root.left = build(start, mid);
      root.right = build(mid + 1, end);
    }
    return root;
  }
}