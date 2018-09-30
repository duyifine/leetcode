package binaryTree;

public class InsertTargetToBST {
  
  public TreeNode insert(TreeNode root, int target) {
    if (root == null) {
      return root;
    }
    
    TreeNode dummy = root;
    while (root.left != null && root.right != null) {
      if (root.value > target) {
        root = root.left;
      } else if (root.value < target) {
        root = root.right;
      } else {
        return dummy;
      }
    }
    if (target > root.value) {
      root.right = new TreeNode(target);
    } else if (target < root.value) {
      root.left = new TreeNode(target);
    } 
    
    return dummy;
  }
  
  public void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    
    System.out.println(root.value);
    inOrder(root.left);
    inOrder(root.right);
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(7);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(20);
    int target = 13;
    InsertTargetToBST i = new InsertTargetToBST();
    TreeNode node = i.insert(root, target);
    i.inOrder(node);
  }
}