// write a code in java using selection sort in a function

import java.util.Scanner;
public class SelectionSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int brr[] = arr.clone();
        selectionSort(arr);

        
        System.out.println("The sorted array is: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("The sorted array using worse selection sort is: ");
        worseSelectionSort(brr);
        for(int i=0; i<n; i++){
            System.out.print(brr[i] + " ");
        }
        System.out.println();
        System.out.println("Thus, worseSelectionSort sort makes unnecessary swaps.");
        sc.close();
    }

    public static void printArray(int[] arr){
        int n = arr.length;
        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }
    }

    // write a worse selection sort that swaps at every iteration
    public static void worseSelectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }

                printArray(arr);
                // print the values of i and j for better understanding
                System.out.println(" for i = "+i+" j = "+j);
            }
        }
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }

                printArray(arr);
                // print the values of i and min for better understanding
                System.out.println(" for i = "+i+" j = "+j);
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            // print the array after each iteration for better understanding

        }
    }

    // are the time complexities of selectionsort and worseselectionsort same?
    // No, the time complexity of selection sort is O(n^2) and the time complexity of worse selection sort is O(n^2) as well.
    // But the number of swaps in selection sort is O(n) and the number of swaps in worse selection sort is O(n^2).
    // so is worseSelectionSort worse than selectionSort?
    // Yes, worseSelectionSort is not better than selectionSort. It is worse than selectionSort because it makes unnecessary swaps.
    
}