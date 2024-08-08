// given an array of integers, move all the even integers at the beginning of the array and all the odd integers at the end of the array
// the sequence does not matter
// implement using a function in java

import java.util.Arrays;
import java.util.Scanner;
class TwoPointersEvenOddIntegers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("The original array is: "+Arrays.toString(arr));
        moveEvenOdd(arr);
        System.out.println("The array after moving all the even integers at the beginning and all the odd integers at the end is: "+Arrays.toString(arr));
    }
    public static void moveEvenOdd(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if (arr[left] %2 == 1 && arr[right] %2 == 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            else if(arr[left] %2 == 0){
                left++;
            }
            else if(arr[right] %2 == 1){
                right--;
            }
        }
    }
}