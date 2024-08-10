// write a code of mergesort using function in java

import java.util.ArrayList;
import java.util.Scanner;
public class MergeSort{
    // use notation beginning, mid and end

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n-1);
        System.out.println("The sorted array is: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    static void mergeSort(int arr[], int beginning, int end){
        if(beginning < end){
            // find the middle point
            int mid = (beginning + end) / 2;
    
            // sort first and second halves
            mergeSort(arr, beginning, mid);
            mergeSort(arr, mid + 1, end);
    
            // merge the sorted halves
            merge(arr, beginning, mid, end);
        }
    }
    // static void merge(int arr[], int beginning, int mid, int end){
    //     // find the size of two subarrays to be merged
    //     int n1 = mid - beginning + 1;
    //     int n2 = end - mid;

    //     // create temp arrays
    //     int L[] = new int[n1];
    //     int R[] = new int[n2];

    //     // copy data to temp arrays
    //     for(int i = 0; i < n1; i++){
    //         L[i] = arr[beginning + i];
    //     }
    //     for(int j = 0; j < n2; j++){
    //         R[j] = arr[mid + 1 + j];
    //     }

    //     // merge the temp arrays
    //     // initial indexes of first and second subarrays
    //     int i = 0, j = 0;

    //     // initial index of merged subarray array
    //     int k = beginning;
    //     while(i < n1 && j < n2){
    //         if(L[i] <= R[j]){
    //             arr[k] = L[i];
    //             i++;
    //         }else{
    //             arr[k] = R[j];
    //             j++;
    //         }
    //         k++;
    //     }

    //     // copy remaining elements of L[] if any
    //     while(i < n1){
    //         arr[k] = L[i];
    //         i++;
    //         k++;
    //     }

    //     // copy remaining elements of R[] if any
    //     while(j < n2){
    //         arr[k] = R[j];
    //         j++;
    //         k++;
    //     }
    // }
    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    
}
