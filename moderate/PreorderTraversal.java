package com.hacker.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 		 5
 * 		/\
 * 	   2  7
 *    /\   \
 *   1  3   9
 */
public class PreorderTraversal {
	static List<Integer> list = new ArrayList<>();
	static Stack<TreeNode> stack = new Stack<>();
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		tree.root = new TreeNode(5); 
       	tree.root.left = new TreeNode(2); 
      	tree.root.right = new TreeNode(7); 
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3); 
        tree.root.left.right.left = new TreeNode(10); 
        tree.root.left.right.right = new TreeNode(18); 
       	tree.root.right.right = new TreeNode(9); 
       	
       	List<Integer> list = preorderRecursive(tree.root);
       	System.out.println(list.toString());
       	
       	List<Integer> listItr = preorderIter(tree.root);
       	System.out.println(listItr.toString());
	}
	/* 		 5
	 * 		/\
	 * 	   2  7				{5,2,1,3,10,18,7,9}
	 *    /\   \
	 *   1  3   9
	 *     / \
	 *    10  18
	 */
	private static List<Integer> preorderIter(TreeNode root) {
		list = new ArrayList<>();
		if (root != null) {
//			stack.add(root);
//			TreeNode node = stack.peek();
//			list.add(node.data);

			preorderSub(root);
			while(!stack.isEmpty()){
				TreeNode currNode = stack.pop();
				//list.add(currNode.data);			//in-order
				if (currNode.right != null) {
					preorderSub(currNode.right);
				}
			}
		}
		return list;
	}
		
	private static void preorderSub(TreeNode node) {
		while (node != null) {
			stack.add(node);
			TreeNode t = stack.peek();			// pre-order
			list.add(t.data);					// pre-order
			node = node.left;
		}
//		TreeNode n = stack.peek();
//		TreeNode right = n.right;
//		
//		if(right == null) 
//			stack.pop();
//		else	
//			preorderSub(right);

	}

	private static List<Integer> preorderRecursive(TreeNode root) {
		if(root == null) {
			return null;
		}
		list.add(root.data);
		preorderRecursive(root.left);
		preorderRecursive(root.right);
	
		return list;
	}
}
