package com.practice.amazon.round2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
	List<Integer> list = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public static void main(String[] args) {
		TreeNode root = null;
		InorderTraversal tree = new InorderTraversal();
		root = tree.insertNode(root, 20);
		root = tree.insertNode(root, 8);
		root = tree.insertNode(root, 22);
		root = tree.insertNode(root, 4);
		root = tree.insertNode(root, 12);
		root = tree.insertNode(root, 10);
		root = tree.insertNode(root, 14);
		
		tree.list = tree.inorderTraversal(root); //4 8 10 12 14 20 22 
		//tree.list = tree.inorderTraversalRecurse(root); //4 8 10 12 14 20 22 1
		tree.list.forEach(i->System.out.print(i+" "));
		
	}
	
	public List<Integer> inorderTraversalRecurse(TreeNode root) {
		if(root == null){
			return null;
		}
		
		inorderTraversalRecurse(root.left);
		list.add(root.data);
		inorderTraversalRecurse(root.right);
		
		return list;
		
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		// push to the stack, and go to left ...
		addToStack(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.data);

			TreeNode right = node.right;
			addToStack(right);
		}
		return list;
	}

	public void addToStack(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	private TreeNode insertNode(TreeNode node, int data) {
		if (node == null) {
			return new TreeNode(data);
		} else {
			TreeNode temp = null;
			if (data <= node.data) {
				temp = insertNode(node.left, data);
				node.left = temp;
			} else {
				temp = insertNode(node.right, data);
				node.right = temp;
			}
			temp.parent = node;

			return node;
		}

	}
}
