public class Solution {

	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	int sumNumbers(TreeNode root, int parentSum) {

		if (root == null) {
			return 0;
		}

		int midResult = parentSum * 10 + root.val;

		if (root.left == null && root.right == null) {
			return midResult;
		}

		return sumNumbers(root.left, midResult) + sumNumbers(root.right, midResult);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(2);

		System.out.println(new Solution().sumNumbers(root));
	}
}