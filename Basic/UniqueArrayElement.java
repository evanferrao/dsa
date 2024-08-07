// find the unique number in a givern array wherer all the elements are being twive with one value being unique using function

import java.util.Scanner;
class UniqueArrayElement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The unique element in the array is "+findUnique(arr));
    }
    public static int findUnique(int[] arr){
        int res = 0;
        for(int i=0;i<arr.length;i++){
            res = res^arr[i];
        }
        return res;
    }

    // dry run: 
    // arr = [1,2,3,4,1,2,3]
    // res = 0
    // res = 0^1 = 1
    // res = 1^2 = 3
    // res = 3^3 = 0
    // res = 0^4 = 4
    // res = 4^1 = 5
    // res = 5^2 = 7
    // res = 7^3 = 4
    // return 4

}