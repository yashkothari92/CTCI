package com.hacker.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagTraversal {

	Stack<TreeNode> stack = new Stack<>();
	List<List<Integer>> listofNodes = new ArrayList<List<Integer>>();
	List<Integer> list = null;
	List<TreeNode> nodeList = null;

	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		ZigzagTraversal obj = new ZigzagTraversal();
		tree.root = new TreeNode(3); 
       	tree.root.left = new TreeNode(9); 
      	tree.root.right = new TreeNode(20); 
        tree.root.right.left = new TreeNode(15); 
       	tree.root.right.right = new TreeNode(7); 
       	
       	List<List<Integer>> lists = obj.zigzagLevelOrder(tree.root);
       	System.out.println(lists.toString());
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		int level = 0;
		stack.push(root);
		while (true) {
			int nodes = stack.size();

			if (nodes == 0) {
				break;
			}
			list = new ArrayList<>();
			nodeList = new ArrayList<>();
			level++;
			// pop all elements from stack, and add it to the list, nodeList
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				list.add(node.data);
				nodeList.add(node);
			}

			// iterate it over nodeList, and node's left & right child to stack
			for (TreeNode node : nodeList) {
				if (level % 2 == 0) {
					if (node.right != null)
						stack.push(node.right);
					if (node.left != null)
						stack.push(node.left);
				} else {
					if (node.left != null)
						stack.push(node.left);
					if (node.right != null)
						stack.push(node.right);
				}
			}
			listofNodes.add(list);
		}
		return listofNodes;
	}
}


