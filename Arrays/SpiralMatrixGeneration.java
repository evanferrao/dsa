// write a program to generate a n * n matrix in spiral order given user input n and the elements of the matrix

import java.util.Scanner;
class SpiralMatrixGeneration{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the matrix");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int length = rows*cols;
        int[][] matrix = new int[rows][cols];
        int lengthArray[] = new int[length];
        System.out.println("Enter the elements of the matrix");
        for(int i=0;i<length;i++){
            lengthArray[i] = sc.nextInt();
        }
        System.out.println("The elements of the matrix in spiral order are:");
        spiralOrder(matrix,rows, cols, lengthArray);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
    public static void spiralOrder(int[][] matrix, int rows, int cols, int lengthArray[]){
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;
        int length_index = 0;
        while(top<=bottom && left<=right){
            // this loop does not need to check for the condition top<=bottom and left<=right as 
            for(int i=left;i<=right;i++){

                matrix[top][i] = lengthArray[length_index++];
            }
            top++;
            // this loop does not need to check for the condition top<=bottom and left<=right as it is already checked in the while loop
            for(int i=top;i<=bottom;i++){
                matrix[i][right] = lengthArray[length_index++];
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    matrix[bottom][i] = lengthArray[length_index++];
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left] = lengthArray[length_index++];
                }
                left++;
            }
        }
    }

}