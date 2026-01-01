import java.util.*;
import java.io.*;

class DFS {
    
    public static void dfs(int node, boolean visited[], ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        res.add(node);
        
        for (Integer it: adj.get(node)){
            if (!visited[it]){
                dfs(it,visited, res, adj);
            }
        }
    }
    
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        
        dfs(0,visited, res, adj);
        return res;
    }
    
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<5; i++){
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        ArrayList<Integer> ans = dfsOfGraph(5, adj);
        
        for (Integer it: ans){
            System.out.printf("%d ", it);
        }
    }
}