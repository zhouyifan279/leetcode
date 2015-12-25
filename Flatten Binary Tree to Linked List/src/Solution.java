public class Solution {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		internalFlatten(root);
	}

	TreeNode internalFlatten(TreeNode root) {

		if (root.left == null && root.right == null) {
			return root;
		}

		if (root.left != null) {
			TreeNode end = internalFlatten(root.left);
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = null;
			if (temp == null) {
				return end;
			} else {
				TreeNode end2 = internalFlatten(temp);
				end.right = temp;
				return end2;
			}
		} else {
			return internalFlatten(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);

		new Solution().flatten(root);

		while (root != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
	}
}