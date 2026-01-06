
import java.util.*;

class Main {
    
    public static class Node{
        int row;
        int col;
        int dist;
        
        Node(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    
    public static int[][] nearest(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        
        boolean visited[][]=new boolean[n][m];
        int distance[][]=new int[n][m];
        
        Queue<Node> q = new LinkedList<>();
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]==1){
                    q.add(new Node(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        
        while(!q.isEmpty()){
            Node current = q.poll();
            int row = current.row;
            int col = current.col;
            int dist = current.dist;
            
            distance[row][col]=dist;
            
            for (int i=0; i<4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                
                if (newRow >=0 && newCol >=0 && newRow < n && newCol <m && !visited[newRow][newCol]){
                    q.add(new Node(newRow, newCol, dist+1));
                    visited[newRow][newCol]=true;
                    
                }
            }
        }
        
        return distance;
    }
    public static void main(String[] args) {
        
        int grid[][] = {
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 0}
        };
        
        int result[][] = nearest(grid);
        
        for (int i=0; i<result.length; i++){
            for (int j=0; j<result[0].length; j++){
                System.out.printf("%d ", result[i][j]);
            }
            System.out.printf("\n");
        }
    }
}