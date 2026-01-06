import java.util.*;

public class CycleDetectionDFS {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean dfs(Pair current, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {

        int node = current.node;
        int parent = current.parent;

        vis[node] = true;

        for (int adjacentNode : adj.get(node)) {

            if (!vis[adjacentNode]) {
                if (dfs(new Pair(adjacentNode, node), vis, adj)) {
                    return true;
                }
            }

            // everything except this 'else if' statement is normal DFS
            else if (adjacentNode != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(new Pair(i, -1), vis, adj)) {
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
