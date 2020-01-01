package linked_lists;

import java.util.HashSet;

//#1. sort and find adjacent duplicates & remove
//#2. put it into some HashTable and check contains condition to identify duplicate
//#3. use 2 pointers, one current ; another next if same => duplicate

public class RemoveDups {

	public static void main(String[] args) {
		CustomLinkedList<Integer> ll = new CustomLinkedList<>();
		ll.add(3);
		ll.add(6);
		ll.add(7);
		ll.add(7);
		ll.add(9);
		ll.add(1);
		ll.add(3);
		
		System.out.println("Traversing...");
		ll.traverse();
		System.out.println("\nHead:"+ll.getHead().data);
		//System.out.println("Tail:"+ll.getTail().data);
		
		//System.out.println(ll.getSize());
		
		/*
		 * ll.remove(7); 
		 * ll.remove(1);
		 */
		removeDupsWithHashing(ll.getHead());
		System.out.println();
		//System.out.println("Traversing");
		ll.traverse();
		System.out.println("\nHead:"+ll.getHead().data);
		//System.out.println("Tail:"+ll.getTail().data);
		//System.out.println(ll.getSize());

	}
	
	public static void removeDupsWithHashing(Node<?> head) {
		// [3,6,7,7,9,1]
		Node<?> current = head;
		HashSet<Object> set = new HashSet<>();
		Node prev = null;
		
		while(current != null) {
			if(set.contains(current.data)) {
				prev.next = current.next;
			} else {
				set.add(current.data);
				prev = current;
			}
			current = current.next;
		}	
	}
	
	public static void removeDupsWithoutBuffer(Node<?> head) {
		// [3,6,7,7,9,1]
		Node<?> current = head;
		
		while(current != null) {
			Node nextPtr = current;
			
			while(nextPtr.next != null) {
				if(current.data == nextPtr.next.data) {
					nextPtr.next = nextPtr.next.next;
				} else {
					nextPtr = nextPtr.next;
				}
			}
			current = current.next;
		}	
	}
}
