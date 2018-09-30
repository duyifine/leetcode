package binaryTree;

public class BinarySearchTreeImp {
  public static class TreeNode {
    int label;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      this.label = x;
    }
  }
  
  TreeNode root;
  BinarySearchTreeImp() {
    this.root = null;
  }
  
  public TreeNode search(int key) {
    return search(root, key);
  }
  
  private TreeNode search(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.label == key) {
      return root;
    } else if (root.label < key) {
      return search(root.right, key);
    } else {
      return search(root.left, key);
    }
  }
  
  public void insert(int target) {
    root = insert(root, target);
  }
  
  private TreeNode insert(TreeNode root, int target) {
    if (root == null) {
      root = new TreeNode(target);
      return root;
    }
    
    TreeNode cur = root;
    while (cur != null) {
      if (cur.label < target) {
        cur = cur.right;
      } else if (cur.label > target) {
        cur = cur.left;
      } else {
        return root;
      }
    }
    cur = new TreeNode(target);
    return root;
  }
  
  private TreeNode insertII(TreeNode root, int target) {
    if (root == null) {
      root = new TreeNode(target);
      return root;
    }
    
    if (root.label < target) {
      root.left = insertII(root.left, target);
    } else if (root.label > target) {
      root.right = insertII(root.right, target);
    }
    return root;
  }
  
  public void delete(int target) {
    root = delete(root, target);
  }
  
  private TreeNode delete(TreeNode root, int target) {
    if (root == null) {
      return root;
    }
    
    if (root.label < target) {
      root.right = delete(root.right, target);
    } else if (root.label > target) {
      root.left = delete(root.left, target);
    } else {
      if (root.left == null) {
        root = root.right;
      } else if (root.right == null) {
        root = root.left;
      } else {
        TreeNode smallest = findSmallest(root.right);
        root.label = smallest.label;
        delete(root.right, smallest.label);
      }
    }
    return root;
  }
  
  private TreeNode findSmallest(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}