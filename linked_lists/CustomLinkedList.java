package linked_lists;

class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
}

public class CustomLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private static int count;
	
	public void add(T data) {
		Node<T> newNode = new Node<T>(data); 
		
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;	
	}
	
	public void remove(T data) {
		Node<T> temp = head;
		
		// if head is to be deleted
		if(head.data == data) {
			head =  head.next;
			return;
		}
		
		// other than head, iterate it through Linked-List, adjust `next` pointer to remove.
		while (temp.next != null) {
			if(temp.next.data == data) {
				temp.next = temp.next.next;
				
				// re-setting tail (exclusively for maintenance purpose)
				if(temp.next == null) {
					tail = temp;
				}
				return;
			}
			temp = temp.next;
		}
	}
	
	protected void traverse() {
		count = 0;
		Node<T> temp = head;
		
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
			count++;
		}
	}
	
	protected Node<T> getHead() {
		return head;
	}
	
	protected Node<T> getTail() {
		return tail;
	}
	
	public int getSize() {
		traverse();
		return count;
	}
}
