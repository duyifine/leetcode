package binaryTree;

public class ExpressionTree {
  
  public class ExpressionTreeNode {
    String val;
    ExpressionTreeNode left;
    ExpressionTreeNode right;
    public ExpressionTreeNode(String val) {
      this.val = val;
    }
  }
  
  public Integer calculate(ExpressionTreeNode root) {
    if (root == null || root.left == null || root.right == null) return null;
    return calculateTree(root);
  }
  
  public Integer calculateTree(ExpressionTreeNode root) {
    if (root == null) {
      return null;
    }
    
    Integer leftVal = null;
    try {
      leftVal = Integer.parseInt(root.left.val);
    } catch (Exception e) {
      //do nothing
    }
    Integer rightVal = null;
    try {
      rightVal = Integer.parseInt(root.right.val);
    } catch (Exception e) {
      //do nothing
    }
    if (leftVal != null && rightVal != null) {
      Integer rootVal = null;
      if (root.val.equals("*")) {
        rootVal = leftVal * rightVal;
      }
//      root.val = String.valueOf(rootVal);
      return rootVal;
    }
    Integer left = calculateTree(root.left);
    Integer right = calculateTree(root.right);
    Integer result = null;
    if (left != null && right != null) {
      if (root.val.equals("*")) {
        result = left * right;
      }
    }
    return result;
  }
}