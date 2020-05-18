package com.practice.amazon.round2;

import java.util.ArrayList;
import java.util.List;

//[-2147483648, null, 2147483648]
//[1,1]
//[5,1,4, null, null,3,6]
//[10,5,15,null,null,6,20]
public class ValidateBST {
	List<Long> list = new ArrayList<>();
	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		ValidateBST obj = new ValidateBST();
		tree.root = new TreeNode(5); 
       	tree.root.left = new TreeNode(1); 
      	tree.root.right = new TreeNode(4); 
        tree.root.right.left = new TreeNode(3); 
       	tree.root.right.right = new TreeNode(6); 
        
       	boolean result = isValidBST(tree.root);
    //  boolean result = obj.inorder(tree.root); 
    //  boolean result = isValid(list);
       System.out.println(result);

	}

	private static boolean isValidBST(TreeNode root) {
		return isValidBSTSub(root, null, null);
	}

	private static boolean isValidBSTSub(TreeNode root, TreeNode l, TreeNode r) {
		if(root == null){
			return true;
		}
		System.out.println(root.data);
		if(l != null && root.data <= l.data) {
			return false;
		}
		
		if(r != null && root.data >= r.data) {
			return false;
		}
		
		return isValidBSTSub(root.left, l, root) &&
				isValidBSTSub(root.right, root, r);
	}

	private static boolean isValid(List<Long> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i + 1) - list.get(i) <= 0) {
				return false;
			}
		}
		return true;
	}

	private List<Long> inorder(TreeNode root) {
		if (root == null) {
			return null;
		}

		inorder(root.left);
		//[TODO] find the bug - return value gets overrides with True
		/*
		if(list.size()>=1 && root.data - list.get(list.size()-1) <= 0) {
			return false;
		}*/
		list.add((long) root.data);
		inorder(root.right);
		return list;
	}
}
