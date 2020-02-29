package tree_n_graphs;

public class BalancedTrees {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(6);
		tree.root.right = new TreeNode(16);
		tree.root.left.left = new TreeNode(3);
		//tree.root.left.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(12);
		tree.root.right.right = new TreeNode(21);
		//tree.root.left.left.right = new TreeNode(5);		
		tree.root.right.left.left = new TreeNode(11);
		
		System.out.println("Is Balanced ?"+ isBalanced(tree.root));
	}

	private static boolean isBalanced(TreeNode tree) {
		
		int lh = height(tree.left);
		int rh = height(tree.right);
		System.out.println(lh+","+rh);
		return Math.abs(lh -rh) <= 1;
	}

	private static int height(TreeNode node) {
		if(node == null)
			return 0;
		
		int left_h = height(node.left);
		int right_h = height(node.right);
		return Math.max(left_h, right_h)+1;
	}
}
