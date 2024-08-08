// write a code in java to find out if n numbers are present in an array or not using function. If present, print YES, else print NO
// use a frequency array to solve this problem

import java.util.Scanner;
class MultipleElementsInArrayOrNot{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = inp.nextInt();
        }
        int m = inp.nextInt();
        int[] brr = new int[m];
        for(int i=0; i<m; i++){
            brr[i] = inp.nextInt();
        }
        // why do we need two arrays? because we need to check if the elements of brr are present in arr or not
        MultipleElementsInArrayOrNot obj = new MultipleElementsInArrayOrNot();
        obj.checkMultipleElements(arr, brr);
        inp.close();
    }
    void checkMultipleElements(int[] arr, int[] brr){
        int[] freq = new int[100000];
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }
        for(int i=0; i<brr.length; i++){
            if(freq[brr[i]] > 0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}