package linked_lists;

public class LoopDetection {
	public static void main(String[] args) {
		CustomLinkedList<Character> cll2 = new CustomLinkedList<Character>();
		cll2.add('A');
		cll2.add('B');
		cll2.add('C');
		cll2.add('D');
		cll2.add('E');
		cll2.add('C');
		
		/*[TODO] 
		 * Circular Linked list needs to be created in order to test below implemented methods
		 * Problem asks for Loop detection, but additional loop removal is implemented below
		 * */
	}
	

	/**once we get the node on which slow & fast* collide, we'll move slow* at head, (and will keep fast* at the collision point) 
	 * now keep moving slow* & fast* by 1 until both of them meets at common point
	 * as soon as we do we know that there's next node is same, we'll break fast.next as null. (Based on Flyod's cycle detection algorithm)
	 *[Here node is head of a linked list]
	 **/
	public int removeTheLoop(Node<?> node) {
        Node<?> result = detectLoop(node);
        if(result != null){
            Node<?> slow = node;
            Node<?> fast = result;
            
            while(slow.next != fast.next){
            	slow = slow.next;
            	fast = fast.next;
            }
            fast.next = null; //break the next* of fast. this makes linear linked list.
            return 1;
        }else{
            return 0; //no- cycle/loop detected in a linked-list
        }
    }
	    
	/** to detect cycle/loop in linked list, we start two pointers slow & fast at head,
	* we move slow* by 1, and fast* by 2, if there's a loop, both slow* and fast* will collide.
	* if they hit, we found there's a loop/cycle
	* [Optional: return collision node to the caller for the simplicity of removal operation]
	* @param node - head of the linked list
	* */
	public Node<?> detectLoop(Node<?> node){
        Node<?> slow = node;
        Node<?> fast = node;
        
        while(slow != null && fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return slow;
            }
        }
        return null;	
	}
}
