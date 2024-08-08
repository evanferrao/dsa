// given an array of 1 and 0, sort the array so that all 0s are on the left and all 1s are on the right
// solve using 2 pointers in O(n) time and O(1) space
// solve using a function in java

import java.util.Arrays;
import java.util.Scanner;
class TwoPointersZeroAndOne{
    public static void main(String[] args){
        System.out.println("Enter the number of elements in the array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        //arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(Arrays.toString(sortZeroAndOne(arr)));
    }

    public static int[] sortZeroAndOne(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] == 1 && arr[right] == 0){
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
            if(arr[left] == 0){
                left++;
            }
            if(arr[right] == 1){
                right--;
            }
        }
        return arr;
    }
}