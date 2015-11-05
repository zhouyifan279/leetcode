
public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left != null && root.right == null) {
			return minDepth(root.left) + 1;
		} else if (root.left == null && root.right != null) {
			return minDepth(root.right) + 1;
		} else {
			return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
		}
	}
}
