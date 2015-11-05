
public class Solution {
	// public TreeNode sortedArrayToBST(int[] nums) {
	//
	// if (nums == null || nums.length == 0) {
	// return null;
	// }
	//
	// int length = nums.length;
	// int rootIndex = (length - 1) / 2;
	// TreeNode root = new TreeNode(nums[rootIndex]);
	// if (length == 1) {
	// return root;
	// } else {
	// if (rootIndex > 0) {
	// root.left = sortedArrayToBST(subArray(nums, 0, rootIndex - 1));
	// }
	//
	// if (rootIndex < length - 1) {
	// root.right = sortedArrayToBST(subArray(nums, rootIndex + 1, length - 1));
	// }
	//
	// return root;
	// }
	// }
	//
	// int[] subArray(int[] nums, int start, int end) {
	// int[] a = new int[end - start + 1];
	// for (int i = 0; i < a.length; i++) {
	// a[i] = nums[start + i];
	// }
	//
	// return a;
	// }

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
