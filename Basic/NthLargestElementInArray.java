// write a code to find nth largest element in an array using function

import java.util.Scanner;
class NthLargestElementInArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of n");
        int nth = sc.nextInt();
        System.out.println("The nth largest element in the array is: "+nthLargestElement(arr,nth));
        sc.close();
    }
    public static int nthLargestElement(int[] arr, int n){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[n-1];
    }
}