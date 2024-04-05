class Solution {

  public int maxAncestorDiff(TreeNode root) {
    return traverse(root, root.val, root.val);
  }

  private int traverse(TreeNode root, int min, int max) {
    if (root == null) {
      return 0;
    }

    int diff = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
    min = Math.min(root.val, min);
    max = Math.max(root.val, max);
    diff = Math.max(diff, traverse(root.left, min, max));
    diff = Math.max(diff, traverse(root.right, min, max));
    return diff;
  }
}