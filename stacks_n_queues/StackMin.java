package stacks_n_queues;

import java.util.Iterator;
import java.util.Stack;

public class StackMin {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> sMin = new Stack<Integer>();

	public static void main(String[] args) {
		StackMin minStack = new StackMin();
		minStack.push(12);
		minStack.push(23);
		minStack.push(2);
		
		minStack.traverse();
		
		int minElem = minStack.min();
		System.out.println("\nMinimum Element: "+minElem);
		
		int popeed = minStack.pop();
		System.out.println("\nPopped element: "+popeed);
		
	//	minStack.traverse();		
		minElem = minStack.min();
		System.out.println("\nMinimum Element: "+minElem);
	}
	
	private void traverse() {
		Iterator<Integer> itr = s1.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
	}

	private void push(int i) {
		if(sMin.size() == 0 || sMin.peek()>i) {
			sMin.add(i);
		}
		s1.add(i);
	}
	
	private int pop() {
		if(sMin.peek() == s1.peek()) {
			sMin.pop();
		}
		
		return s1.pop();
	}
	
	private int min() {
		if(sMin.size() == 0)
			return -1; //error
		return sMin.peek();
	}
}
