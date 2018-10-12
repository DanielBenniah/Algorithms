import java.io.*;
import java.util.*;

class DFS {

	private List<LinkedList<Integer>> adj;

	private int nodes = 0;

	public DFS (int a) {

		adj = new LinkedList<LinkedList<Integer>>();

		nodes = a;
		for (int i = 0; i < a; i++)
			adj.add(new LinkedList<Integer>());
	}

	public void addEdge (int a, int b) {
		adj.get(a).add(b);
	}

	public void dfs (int v, boolean[] visited) {
		visited[v] = true;

		System.out.println (" " + v + " ");

		for (int i = 0; i < adj.get(v).size(); i++) {
			if (!visited[adj.get(v).get(i)])
				dfs (adj.get(v).get(i), visited);
		}
	}

	public static void main (String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodes = 4;
		DFS g = new DFS(nodes);

		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);

        boolean[] visited = new boolean[nodes];

        g.dfs(1, visited);

		//return 0;
	}
}