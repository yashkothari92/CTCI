package tree_n_graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayList;

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
		
		List<List<Integer>> lists = printLevelOrderTraversal(lot.root);
		if(lists != null){
       			System.out.println(lists);
       		}
	}

	private static List<List<Integer>> printLevelOrderTraversal(TreeNode root) {
		if(root == null){
	            return new ArrayList<List<Integer>>();
	     	}
		List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(true) {
			int nodeCount = queue.size();
			if(nodeCount == 0)
				break;
			
			list = new ArrayList<>();
			while(nodeCount > 0) {
				TreeNode n = queue.poll();
				list.add(n.data);
				if (n.left != null) {
					queue.add(n.left);
				}
				
				if (n.right != null) {
					queue.add(n.right);
				}
				nodeCount --;
			}	
			listOfList.add(list);
		}
		return listOfList;
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
