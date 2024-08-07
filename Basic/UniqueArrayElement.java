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
        sc.close();
        // is there any way to show the time taken by each function to find the unique element in the array?
        // yes, we can use the System.currentTimeMillis() function to get the current time in milliseconds
        // we can use this function to get the time before and after the function call
        // then we can subtract the two times to get the time taken by the function to execute
        // can you rewrite the above code to show the time taken by each function to find the unique element in the array?
        // write the code to show the time taken by each function to find the unique element in the array
        long start = System.currentTimeMillis();
        System.out.println("The unique element in the array is "+findUniqueUsingXOR(arr));
        long end = System.currentTimeMillis();
        System.out.println("Time taken by findUnique function is "+(end-start)+" milliseconds");
        start = System.currentTimeMillis();
        System.out.println("The unique element in the array is "+findUniqueUsingMapping(arr));
        end = System.currentTimeMillis();
        System.out.println("Time taken by findUniqueUsingMapping function is "+(end-start)+" milliseconds");
        start = System.currentTimeMillis();
        System.out.println("The unique element in the array is "+findUniqueBruteforce(arr));
        end = System.currentTimeMillis();
        System.out.println("Time taken by findUniqueBruteforce function is "+(end-start)+" milliseconds");
    }
    public static int findUniqueUsingXOR(int[] arr){
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

    // write another function using hasing technique to find the unique element in the array
    // write using mapping technique to find the unique element in the array
    // DO NOT USE XOR
    // make another array of size of the largest element in the array and then map the elements of the array to the new array
    // then find the element which is mapped to 1
    // return that element
    // return -1 if no such element is found
    // write the code for the above logic
    static int findUniqueUsingMapping(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int[] map = new int[max+1];
        for(int i=0;i<arr.length;i++){
            map[arr[i]]++;
        }
        for(int i=0;i<map.length;i++){
            if(map[i]==1){
                return i;
            }
        }
        return -1;
    }

    // write a bruteforce method to find the unique element in the array
    // compare each element with all the other elements in the array
    // if the element is not found in the array then return that element
    // return -1 if no such element is found
    static int findUniqueBruteforce(int[] arr){
        for(int i=0;i<arr.length;i++){
            boolean found = false;
            for(int j=0;j<arr.length;j++){
                if(i!=j && arr[i]==arr[j]){
                    found = true;
                    break;
                }
            }
            if(!found){
                return arr[i];
            }
        }
        return -1;
    }

}