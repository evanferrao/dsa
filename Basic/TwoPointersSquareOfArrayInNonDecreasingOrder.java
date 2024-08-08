// given an integer array 'a' sorted in non decreasing order, return an array of the squares of each number, also sorted in non decreasing order
// ex. [-4,-1,0,3,10] -> [0,1,9,16,100]
// ex. [-7,-3,2,3,11] -> [4,9,9,49,121]

import java.util.Scanner;

public class TwoPointersSquareOfArrayInNonDecreasingOrder{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        int[] result = sortedSquares(a);
        System.out.println("The array of squares of each number, also sorted in non decreasing order is: ");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    public static int[] sortedSquares(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        int left = 0;
        int right = n-1;
        for(int i=n-1;i>=0;i--){
            if(Math.abs(a[left])>Math.abs(a[right])){
                result[i] = a[left]*a[left];
                left++;
            }
            else{
                result[i] = a[right]*a[right];
                right--;
            }
        }
        return result;
    }
}