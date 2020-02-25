package tree_n_graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// BFS (Breadth First Search)
public class RouteBetweenTwoNodes {

	private int V; // no of vertices
	private LinkedList<Integer> adjList[]; // Adjacency List

	public RouteBetweenTwoNodes(int v) {
		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	private void addEdge(int i, int j) {
		adjList[i].add(j);
	}

	public static void main(String[] args) {
		// Create a graph given in the above diagram
		RouteBetweenTwoNodes g = new RouteBetweenTwoNodes(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		int src = 0;
		int dest = 3;
		//boolean result = g.routeExists(src, dest);
		g.DFS(src);
		
	//	System.out.println("Route between node "+src+" and "+dest+" : "+result);
	}

	private void DFS(int s) {
		boolean visited[] = new boolean[V];
		DFSHelper(s, visited);
	}
	
	private void DFSHelper(int s, boolean[] visited) {
		// array will store if node is visited or not
		visited[s] = true;
		System.out.print(s+" ");
		
		Iterator<Integer> itr = adjList[s].iterator();
		Integer node;
		while(itr.hasNext()) {
			node = itr.next();
			if(!visited[node])
				DFSHelper(node, visited);	
		}
	}

	private boolean routeExists(int s, int d) {

		// array will store if node is visited or not
		boolean visited[] = new boolean[V];

		// queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// initially set source as visited, and put it into queue.
		visited[s] = true;
		queue.add(s);

		Iterator<Integer> i;
		
		// keep iterating over it until queue is nonEmpty
		while (queue.size() > 0) {
			s = queue.poll();

			i = adjList[s].listIterator();

			while (i.hasNext()) {
				int node = i.next();
				// if match found from the adjacency list, returns true
				if (node == d) {
					return true;
				} // else mark it visited and add it to the queue (if not already)
					else {
					if(!visited[node]) {
						visited[node] = true;
						queue.add(node);
					}
				}
			}
		}

		return false;

	}

}
