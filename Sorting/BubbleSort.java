// write a bubble sort code in java using function

import java.util.Scanner;
public class BubbleSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr);
        System.out.println("The sorted array is:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
    }
    public static void printArray(int[] arr){
        int n = arr.length;
        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            // print the array after each iteration for better understanding
            printArray(arr);
            // print the values of i and j for better understanding
            System.out.println(" for i = "+i+" j = "+j);
            }
        }
    }
}