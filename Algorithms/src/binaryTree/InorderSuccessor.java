package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class InorderSuccessor {
  
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null || p == null) {
      return null;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    while (root != null) {
      if (p.value < root.value) {
        root = root.left;
      } else if (p.value > root.value) {
        root = root.right;
      } else {
        if (root.right != null) {
          root = root.right;
          while (root.left != null) {
            root = root.left;
          }
          return root;
        } else {
          while (!stack.isEmpty()) {
            if (stack.peekFirst().value > p.value) {
              return stack.pollFirst();
            }
            stack.pollFirst();
          }
          break;
        }
      }
      stack.offerFirst(root);
    }
    return null;
  }
  
  public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
    if (root == null) {
      return null;
    }
    
    if (root.value <= p.value) {
      return inorderSuccessorII(root.right, p);
    } else {
      TreeNode left = inorderSuccessorII(root.left, p);
      if (left != null) {
        return left;
      } else {
        return root;
      }
    }
  }
  
  public static void main(String[] args) {
    InorderSuccessor t = new InorderSuccessor();
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.right = new TreeNode(22);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    root.right = new TreeNode(22);
    System.out.println(t.inorderSuccessor(root, new TreeNode(8)).value);
    System.out.println(t.inorderSuccessorII(root, new TreeNode(8)).value);
    System.out.println(t.inorderSuccessor(root, new TreeNode(10)).value);
    System.out.println(t.inorderSuccessorII(root, new TreeNode(10)).value);
    System.out.println(t.inorderSuccessor(root, new TreeNode(14)).value);
    System.out.println(t.inorderSuccessorII(root, new TreeNode(14)).value);
    }
}