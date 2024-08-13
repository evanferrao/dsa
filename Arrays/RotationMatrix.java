// wrie a code in java to print the rotation matrix using the functions calculateRotation and calculateTranspose
import java.util.Scanner;
class RotationMatrix{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the elements of the matrix: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Original Matrix: ");
        printMatrix(matrix);
        System.out.println("Transpose Matrix: ");
        printMatrix(calculateTranspose(matrix));
        System.out.println("Rotation Matrix: ");
        printMatrix(calculateRotation(matrix));
        sc.close();
    }
    public static int[][] calculateTranspose(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transpose = new int[columns][rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
    public static int[][] calculateRotation(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] rotation = new int[columns][rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                rotation[j][rows - i - 1] = matrix[i][j];
            }
        }
        return rotation;
    }
    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // calculate rotation from transpose

    public static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static int[][] calculateRotationFromTranspose(int[][] matrix){
        int transpose[][] =  calculateTranspose(matrix);
        for (int i = 0; i < transpose.length; i++) {
            reverseArray(transpose[i]);
        }

        return transpose;
    }
}