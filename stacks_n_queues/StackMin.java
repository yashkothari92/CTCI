package stacks_n_queues;

import java.util.Iterator;
import java.util.Stack;

// push, push, push, push
public class StackMin {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> sMin = new Stack<Integer>();

	public static void main(String[] args) {
		StackMin obj = new StackMin();
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
		obj.pop();
		int param_2 = obj.getMin();
		System.out.println(param_2);
		obj.pop();
		int param_3 = obj.getMin();
		System.out.println(param_3);
		obj.pop();
		int param_4 = obj.getMin();
		System.out.println(param_4);
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
	
	private void pop() {
		int a = s1.peek();
		int b = sMin.peek();

		if(a == b) {
		    s1.pop();
		    sMin.pop();
		} else {
		    s1.pop();
		}
	}
	
	private int min() {
		if(sMin.size() == 0)
			return -1; //error
		return sMin.peek();
	}
}
