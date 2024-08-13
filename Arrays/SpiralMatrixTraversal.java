// write a code in java to print the elements in a matrix in a spiral order using functions

import java.util.Scanner;
class SpiralMatrixTraversal{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the matrix");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("The elements of the matrix in spiral order are:");
        spiralOrder(matrix,rows,cols);
        sc.close();
    }
    public static void spiralOrder(int[][] matrix, int rows, int cols){
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;
        while(top<=bottom && left<=right){
            // this loop does not need to check for the condition top<=bottom and left<=right as 
            for(int i=left;i<=right;i++){
                System.out.print(matrix[top][i]+" ");
            }
            top++;
            // this loop does not need to check for the condition top<=bottom and left<=right as it is already checked in the while loop
            for(int i=top;i<=bottom;i++){
                System.out.print(matrix[i][right]+" ");
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    System.out.print(matrix[bottom][i]+" ");
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    System.out.print(matrix[i][left]+" ");
                }
                left++;
            }
        }
    }
}