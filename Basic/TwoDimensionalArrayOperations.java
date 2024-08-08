// take input of two 2D arrays and print the sum of the two arrays
// also multiply the two arrays and print the result
// multiply only if the number of columns of the first array is equal to the number of rows of the second array

import java.util.Scanner;
public class TwoDimensionalArrayOperations{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the first array");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        System.out.println("Enter the number of rows and columns of the second array");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        if(c1 != r2){
            System.out.println("The number of columns of the first array is not equal to the number of rows of the second array. So, multiplication is not possible");
            sc.close();
            return;
        }
        int[][] arr1 = new int[r1][c1];
        int[][] arr2 = new int[r2][c2];
        System.out.println("Enter the elements of the first array");
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of the second array");
        for(int i = 0; i < r2; i++){
            for(int j = 0; j < c2; j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        int[][] sum = new int[r1][c1];
        int[][] product = new int[r1][c2];
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                product[i][j] = 0;
                for(int k = 0; k < c1; k++){
                    product[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        System.out.println("The sum of the two arrays is:");
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The product of the two arrays is:");
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}