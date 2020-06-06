package com.hacker.amazon;

public class SortedArrayToBalancedBST {
	public static void main(String[] args) {
		int arr[] = {-10,-3,0,5,9};
		
		int start = 0;
		int end = arr.length - 1;
		TreeNode root = convertToBST(arr, start, end);
	}

	private static TreeNode convertToBST(int[] arr, int start, int end) {	
		while (start > end) {
			return null;
		}
		int mid = (start +  end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		
		root.left = convertToBST(arr, start, mid - 1);
		root.right = convertToBST(arr, mid+1, end);
		return root;
	}
}
