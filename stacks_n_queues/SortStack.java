package stacks_n_queues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class SortStack {
	static Stack<Integer> s = new Stack<>();
	static Stack<Integer> sortedStack = new Stack<>();
	
	public static void main(String[] args) {
		s = buildStack();
		traverseme(s);

		sortedStack = sortStack();
		traverseme(sortedStack);
	}

	private static void traverseme(Stack<Integer> sortedStack2) {
		Iterator<Integer> itr = sortedStack2.iterator();
		System.out.println();
		while(itr.hasNext()) {
			System.out.print(itr.next()+"  ");
		}
	}

	private static Stack<Integer> sortStack() {
		while (!s.isEmpty()) {
			int curr_element = s.pop(); 
			//if (sortedStack.isEmpty() || curr_element > sortedStack.peek()) {
		//		sortedStack.push(curr_element);
		//	} else {
				// list needs to be initialized for every new element visited in original stack
				List<Integer> list = new ArrayList<>();
				while (!sortedStack.isEmpty() && sortedStack.peek() > curr_element) {
					int temp_holder = sortedStack.pop();
					list.add(temp_holder);
				}
				sortedStack.push(curr_element);
				for (int i = list.size()-1; i >= 0; i--) {
					sortedStack.push(list.get(i));
				}
			//}
		}
		
		return sortedStack;
	}

	private static Stack<Integer> buildStack() {
		s.push(8);
		s.push(2);
		s.push(9);
		s.push(1);
		s.push(0);
		s.push(5);
		s.push(24);
		s.push(3);
		s.push(6);
		
		return s;
	}
}
