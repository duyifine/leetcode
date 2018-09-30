package binaryTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PreorderSerializeAndDeserialize {
  
  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    StringBuilder sb = new StringBuilder();
    buildString(root,sb);
    return sb.toString();
  }
  
  public void buildString(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#,");
    } else {
      sb.append(root.value).append(",");
      buildString(root.left, sb);
      buildString(root.right, sb);
    }
  }
  
  public TreeNode deserialize(String data) {
    if (data == null) {
      return null;
    }
    
    Deque<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(",")));
    return buildTree(nodes);
  }
  
  public TreeNode buildTree(Deque<String> nodes) {
    String top = nodes.remove();
    if (top.equals("#")) {
      return null;
    } else {
      TreeNode node = new TreeNode(Integer.parseInt(top));
      node.left = buildTree(nodes);
      node.right = buildTree(nodes);
      return node;
    }
  }
  
  public static void main(String[] args) {
    PreorderSerializeAndDeserialize t = new PreorderSerializeAndDeserialize();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(t.serialize(root));
    System.out.println(t.serialize(t.deserialize(t.serialize(root))));
  }
}