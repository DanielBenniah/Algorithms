import java.io.*;
import java.util.*;

class BFS {

    private List<LinkedList<Integer>> adj;

    private int nodes = 0;

    public BFS (int a) {

        adj = new LinkedList<LinkedList<Integer>>();

        nodes = a;
        for (int i = 0; i < a; i++)
            adj.add(new LinkedList<Integer>());
    }

    public void addEdge (int a, int b) {
        adj.get(a).add(b);
    }

    void bfs(int v) {
        boolean visited[] = new boolean[nodes];
        visited[v] = true;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(v);

        while (queue.size() != 0) {

            int current = queue.poll();
            System.out.println(current);

            for (int i = 0; i < adj.get(current).size(); i++) {
                if (!visited[adj.get(current).get(i)]) {
                    visited[adj.get(current).get(i)] = true;
                    queue.add(adj.get(current).get(i));
                }
            }
        }

    }

    public static void main (String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodes = 4;
        BFS g = new BFS(nodes);

        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);

        boolean[] visited = new boolean[nodes];

        g.bfs(2);

        //return 0;
    }
}