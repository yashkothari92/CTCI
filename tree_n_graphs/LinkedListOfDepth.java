package tree_n_graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedListOfDepth {

	public static ArrayList<LinkedListNode> linkedLists = new ArrayList<>();
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(6);
		tree.root.right = new TreeNode(16);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(12);
		tree.root.right.right = new TreeNode(21);
		tree.root.left.left.right = new TreeNode(5);		
		tree.root.right.left.left = new TreeNode(11);
		
		int d = findDepth(tree.root);
		System.out.println("Depth : "+d);
		
		createLinkedListsOfSDepth(tree.root);
	}

	private static void createLinkedListsOfSDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(queue.size() > 0) {
			int nodes = queue.size();
			LinkedListNode head = null;
			LinkedListNode current = null;
			
			while(nodes > 0) {
				TreeNode node = queue.poll();
		//		System.out.print(node.data+" ");
				
				/*adjusting pointers */
				if(head == null) {
					head = new LinkedListNode(node.data);
					current = head;
				} else {
					current.next = new LinkedListNode(node.data);
					current = current.next;
				}
				
				if(node.left != null) {
					queue.add(node.left);					
				}
				
				if(node.right != null) {
					queue.add(node.right);					
				}
				nodes --;
			}
			linkedLists.add(head);
		//	System.out.println();
		} 
		traverseLinkedList(linkedLists);
	}

	private static void traverseLinkedList(ArrayList<LinkedListNode> linkedLists) {
		System.out.println("size:"+linkedLists.size());
		Iterator<LinkedListNode> itr = linkedLists.iterator();
		while(itr.hasNext()) {
			LinkedListNode node = itr.next();
			LinkedListNode head = node;
			while(head != null) {
				System.out.print(head.data+"->");
				head = head.next;
			}
			System.out.println();
		}
	}

	private static int findDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int lh = findDepth(root.left);
	//	System.out.println(root.data+ "-> lh "+lh);
		int rh = findDepth(root.right);
	//	System.out.println(root.data+" -> rh "+rh);
		
		return Math.max(lh, rh)+1;
	}
}
