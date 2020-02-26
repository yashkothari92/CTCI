package tree_n_graphs;

public class MinimalTree {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11, 13 };
		TreeNode tree = buildMinimalTree(arr);
		traverse(tree);
	}

	/*In-order traversal*/
	private static void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		System.out.print(root.data+" ");
		traverse(root.right);
	}

	private static TreeNode buildMinimalTree(int[] arr) {
		return buildMinimalTree(arr, 0, arr.length - 1);
	}

	private static TreeNode buildMinimalTree(int[] arr, int start, int end) {
		if (end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode t = new TreeNode(arr[mid]);

		t.left = buildMinimalTree(arr, start, mid - 1);
		t.right = buildMinimalTree(arr, mid + 1, end);
		return t;
	}
}
