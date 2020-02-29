package tree_n_graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LevelOrderTraversal {

	TreeNode root;
	
	public static void main(String[] args) {
		LevelOrderTraversal lot = new LevelOrderTraversal();
		lot.root = new TreeNode(3);
		lot.root.left = new TreeNode(10);
		lot.root.right = new TreeNode(21);
		lot.root.left.left = new TreeNode(9);
		lot.root.left.right = new TreeNode(12);
		lot.root.right.left = new TreeNode(13);
		lot.root.right.right = new TreeNode(16);
		lot.root.left.left.left = new TreeNode(20);
		lot.root.right.left.right = new TreeNode(26);
		lot.root.right.right.left = new TreeNode(30);
		
		int d = findDepth(lot.root);
	//	System.out.println(d);
		
		printLevelOrderTraversal(lot.root);
	}

	private static void printLevelOrderTraversal(TreeNode root) {
		//List<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
	//	System.out.println(root.data);
		
		while(true) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			
			while(nodeCount > 0) {
				TreeNode n = queue.poll();
				System.out.print(n.data+" ");
				if (n.left != null) {
					queue.add(n.left);
				//	System.out.print(n.left.data+" ");
				}
				
				if (n.right != null) {
					queue.add(n.right);
				//	System.out.print(n.right.data+" ");
				}
				nodeCount --;
			}	
			System.out.println();
		}
		
	}

	private static int findDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = findDepth(root.left);
		int right = findDepth(root.right);
		int depth = Math.max(left, right)+1;
		return depth;		
	}
}
