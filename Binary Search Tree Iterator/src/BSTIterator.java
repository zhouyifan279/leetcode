import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

	private Deque<TreeNode> stack = new ArrayDeque<>();

	private void dive(TreeNode root) {
		if (root != null) {
			stack.push(root);
			dive(root.left);
		}
	}

	public BSTIterator(TreeNode root) {
		dive(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode min = stack.pop();
		dive(min.right);
		return min.val;

	}

	public static void main(String[] args) {
		int[] nums = {0};
		Solution s = new Solution();
		TreeNode root = s.sortedArrayToBST(nums);
		BSTIterator it = new BSTIterator(root);
		
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
	}

	static class Solution {
		public TreeNode sortedArrayToBST(int[] nums) {
			if (nums == null || nums.length == 0) {
				return null;
			}
			int start = 0;
			int end = nums.length - 1;

			return sortedArrayToBST(nums, start, end);
		}

		public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
			int rootIndex = (end + start) / 2;
			TreeNode root = new TreeNode(nums[rootIndex]);
			if (start == end) {
				return root;
			} else {
				if (rootIndex > start) {
					root.left = sortedArrayToBST(nums, start, rootIndex - 1);
				}

				if (rootIndex < end) {
					root.right = sortedArrayToBST(nums, rootIndex + 1, end);
				}

				return root;
			}
		}
	}
}