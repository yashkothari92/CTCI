package linked_lists;

class PartialHolder {
	Node sum = null;
	int carry = 0;
}

//case 2: Linked List are stored in forward order :
//	617 represented as		 	   6 -> 1 > 7
//   59 represented as 			   5 -> 9     * need to prepend 0 to align both LinkedLists 
// Resultant linked list should be 7 -> 7 -> 5

public class SumListsForward {
	public static void main(String[] args) {

		CustomLinkedList<Integer> custll = new CustomLinkedList<Integer>();
		custll.add(9);
		custll.add(0);
		custll.add(7);
		Node custllHead = custll.getHead(); 
		int custllSize = custll.getSize();
		System.out.println();
		
		CustomLinkedList<Integer> custll2 = new CustomLinkedList<Integer>();
		custll2.add(3);
		custll2.add(2);
		custll2.add(9);
		
		Node custll2Head = custll2.getHead();
		int custll2Size = custll2.getSize();
		System.out.println();
		
		Node custLL1Node = custll.getHead();
		Node custLL2Node = custll2.getHead();
		
		System.out.println("\naddition of LinkedList1 & LinkedList2 (forward)");
		Node addFwd = addLinkedListForward(custLL1Node, custLL2Node);
		
		while(addFwd != null) {
			System.out.print(addFwd.data + " ");
			addFwd = addFwd.next;
		}
	}
	
	private static Node addLinkedListForward(Node custLL1Node, Node custLL2Node) {
		// find Lenght of each LinkedList 
		int len1 = SumLinkedListsBackward.length(custLL1Node);
		int len2 = SumLinkedListsBackward.length(custLL2Node);
		
		// pad shorter LinkedList with zeros()
		if(len1 < len2) {
			custLL1Node = padListFront(custLL1Node, len2 - len1);
		} else if(len2 < len1) {
			custLL2Node = padListFront(custLL2Node, len1 - len2);	
		}
		
		PartialHolder sum = addLinkedListForwardSub(custLL1Node, custLL2Node);
		
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = insertAtHead(sum.sum, sum.carry);
			return result;
		}
	}
	
	private static PartialHolder addLinkedListForwardSub(Node ll1, Node ll2) {
		if (ll1 == null && ll2 == null) {
			PartialHolder sum = new PartialHolder();
			return sum;
		}
		
		PartialHolder sum = addLinkedListForwardSub(ll1.next, ll2.next);
		
		int val = sum.carry + (Integer)ll1.data + (Integer)ll2.data;
		
		int res = val;
		if(val > 10) {
			res = val%10;
		}
		
		Node full_result = insertAtHead(sum.sum, res);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	private static Node insertAtHead(Node sum, int res) {
		Node newNode = new Node(res);
		if (sum == null){
			sum = newNode;
			return newNode;
		}
		
		newNode.next = sum;
		return newNode;
	}

	private static Node padListFront(Node node, int i) {
		while(i>0) {
			node = insertBefore(node, 0);
			i--;
		}
		return node;
	}

	private static Node insertBefore(Node node, int i) {
		Node paddedNode = new Node(i);
		paddedNode.next = node;
		return paddedNode;
	}
}
