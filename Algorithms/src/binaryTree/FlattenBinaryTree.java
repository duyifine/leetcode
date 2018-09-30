package binaryTree;

public class FlattenBinaryTree {
  
  TreeNode prev = null;
  public void flattenInOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    
    flattenInOrder(root.right);
    flattenInOrder(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
  }
  
  public void flattenPreOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    
    flattenPreOrder(root.left);
    if (prev != null) {
      root.left = prev;
      prev.right = root;
      System.out.println("root=" + root.value);
      System.out.println("root.left=" + prev.value);
    } else {
      System.out.println("root=" + root.value);
    }
    prev = root;
    flattenPreOrder(root.right);
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    FlattenBinaryTree f = new FlattenBinaryTree();
    f.flattenPreOrder(root);
  }
}