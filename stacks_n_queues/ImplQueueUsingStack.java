package stacks_n_queues;

import java.util.Stack;

public class ImplQueueUsingStack {

	Stack<Integer> s1 = new Stack<>();		//mainly for enqueue operation
	Stack<Integer> s2 = new Stack<>();		// mainly used for dequeue operation

	public static void main(String[] args) {

		ImplQueueUsingStack queue = new ImplQueueUsingStack();
		queue.enqueue(2);
		queue.enqueue(9);
		queue.enqueue(12);
		queue.enqueue(4);
		queue.enqueue(8);

		System.out.println(queue.dequeue());
		queue.enqueue(14);
		queue.enqueue(66);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println("peeking: "+queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(91);

	}

	private void enqueue(int i) {
		s1.push(i);
	}
	
	private int dequeue() {
		moveElements();		
		return s2.pop();
	}

	private int peek() {
		moveElements();		
		return s2.peek();
	}

	
	private void moveElements() {
		if(s2.isEmpty()) {
			// push elements to s2 by popping off s1
			while(!s1.isEmpty()) {
				s2.add(s1.pop());
			}
		}		
	}
}
