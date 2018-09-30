package binaryTree;

public class LowestCommonAncestor {
  
  public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
    if (root == null) {
      return null;
    }
    if (root == one || root == two) {
      return root;
    }
    
    TreeNode leftLCA = LCA(root.left, one, two);
    TreeNode rightLCA = LCA(root.right, one, two);
    
    if (leftLCA != null && rightLCA != null) {
      return root;
    } else if (leftLCA != null) {
      return leftLCA;
    } else {
      return rightLCA;
    }
  }
  
  public TreeNodeP LCAWithParentNode(TreeNodeP one, TreeNodeP two) {    
    int length1 = length(one);
    int length2 = length(two);
    if (length1 <= length2) {
      return helper(one, two, length2 - length1);
    } else {
      return helper(two, one, length1 - length2);
    }
  }
  
  public TreeNodeP helper(TreeNodeP one, TreeNodeP two, int diff) {
    while (diff > 0) {
      two = two.parent;
      diff--;
    }
    while (one != two) {
      one = one.parent;
      two = two.parent;
    }
    return one;
  }
  
  public int length(TreeNodeP node) {
    int length = 0;
    if (node.parent != null) {
      node = node.parent;
      length++;
    }
    return length;
  }
}