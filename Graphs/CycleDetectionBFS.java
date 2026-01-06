import java.util.*;

public class CycleDetectionBFS {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean bfs(int src, int V, ArrayList<ArrayList<Integer>> adj,boolean[] vis) {

        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (int adjacentNode : adj.get(node)) {
                if (!vis[adjacentNode]) {
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                }

                // everything except this 'else if' statement is normal BFS
                else if (adjacentNode != parent) {
                    return true; // cycle detected
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfs(i, V, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(1); // creates a cycle
        adj.get(1).add(3);

        adj.get(3).add(4);
        adj.get(4).add(3);

        System.out.printf(isCycle(V, adj) ? "Cycle detected" : "No cycle detected");
    }
}
