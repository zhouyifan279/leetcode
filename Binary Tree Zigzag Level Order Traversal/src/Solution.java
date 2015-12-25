import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		int direct = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ret = new LinkedList<>();
		int siblingNum = 0;

		if (root != null) {
			queue.add(root);
			siblingNum = 1;
		}

		List<Integer> list = new LinkedList<>();
		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			siblingNum--;

			if (direct == 1) {
				list.add(node.val);
			} else {
				list.add(0, node.val);
			}

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}

			if (siblingNum == 0) {
				siblingNum = queue.size();
				ret.add(list);
				list = new LinkedList<>();
				direct = direct * -1;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);

		List<List<Integer>> ret = new Solution().zigzagLevelOrder(root);

		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}
}