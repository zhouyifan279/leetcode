import org.junit.Test;

public class SolutionTest {
//	@Test
//	public void testSubArray() {
//		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
//		int[] b = new Solution().subArray(a, 3, 5);
//
//		assert (b[0] == a[3] && b[2] == a[5]);
//	}

	@Test
	public void test() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode root = new Solution().sortedArrayToBST(a);
		int capcity = 1;
		while (capcity < a.length) {
			capcity = capcity * 2 + 1;
		}

		int[] vals = new int[capcity];
		treeToArray(root, vals, 0);
		for (int i : vals) {
			System.out.print(i + " ");
		}
	}

	public void treeToArray(TreeNode root, int[] vals, int start) {
		vals[start] = root.val;
		if (root.left != null) {
			treeToArray(root.left, vals, start * 2 + 1);
		}

		if (root.right != null) {
			treeToArray(root.right, vals, start * 2 + 2);
		}
	}
}
