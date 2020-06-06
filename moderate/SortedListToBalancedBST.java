package com.hacker.amazon;

public class SortedListToBalancedBST {

	public static void main(String[] args) {
		CustomLinkedList<Integer> ll = new CustomLinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		
		Node head = ll.getHead();
		TreeNode root = convertToBalancedBST(head);
		System.out.println(root);
	}

	private static TreeNode convertToBalancedBST(Node head) {
		if(head == null){
			return null;
		}
		
		return convertToBalancedBSTSub(head, null);
	}
		
	private static TreeNode convertToBalancedBSTSub(Node head, Node tail) {
		Node slow = head;
		Node fast = head;
		
		if(head == tail){
			return null;
		}
		
		while(fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode root = new TreeNode((Integer)slow.data);
		root.left = convertToBalancedBSTSub(head, slow);
		root.right = convertToBalancedBSTSub(slow.next, tail);
		
		return root;
	}
}
