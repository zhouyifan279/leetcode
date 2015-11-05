
public class Test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		
		System.out.println(new Solution().minDepth(root));
	}
}
