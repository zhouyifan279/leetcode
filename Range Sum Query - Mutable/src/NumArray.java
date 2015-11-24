public class NumArray {

	class SegmentTreeNode {
		int start;
		int end;
		int sum;
		SegmentTreeNode left;
		SegmentTreeNode right;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			sum = 0;
			left = null;
			right = null;
		}
	}

	private SegmentTreeNode root = null;

	public NumArray(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}

	void update(int i, int val) {
		updateTree(root, i, val);
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		} else {
			SegmentTreeNode root = new SegmentTreeNode(start, end);
			if (start == end) {
				root.sum = nums[start];
			} else {
				int mid = start + (end - start) / 2;
				root.left = buildTree(nums, start, mid);
				root.right = buildTree(nums, mid + 1, end);
				root.sum = root.left.sum + root.right.sum;
			}
			return root;
		}
	}

	private void updateTree(SegmentTreeNode root, int pos, int val) {
		if (root.start == root.end) {
			root.sum = val;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (pos <= mid) {
				updateTree(root.left, pos, val);
			} else {
				updateTree(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}

	private int sumRange(SegmentTreeNode root, int i, int j) {
		if (root.start == i && root.end == j) {
			return root.sum;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (j <= mid) {
				return sumRange(root.left, i, j);
			} else if (i > mid) {
				return sumRange(root.right, i, j);
			} else {
				return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5 };
		NumArray a = new NumArray(nums);
		a.sumRange(0, 2);
		a.update(1, 2);
		a.sumRange(0, 2);
	}
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);