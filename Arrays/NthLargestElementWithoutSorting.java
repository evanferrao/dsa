// write a code in java to print the Nth largest element in an array without sorting the array.
// approach: we keep replacing the largest element with INT_MIN and keep track of the largest element in the array.
// if we want to find the Nth largest element, we repeat the above step N times.
/*


class NthLargestElementWithoutSorting{
        public static void main(String[] args){
        int[] arr = {2, 4, 5, 1, 7, 8, 6, 3};
        int n = 3;
        int NthLargestElement = NthLargestElement(arr, n);
        System.out.println(NthLargestElement);
    }

    public static int NthLargestElement(int[] arr, int n){
        int NthLargestElement = 0;
        for(int i=0; i<n; i++){
            int largest = Integer.MIN_VALUE;
            for(int j=0; j<arr.length; j++){
                if(arr[j] > largest){
                    largest = arr[j];
                }
            }
            NthLargestElement = largest;
            for(int j=0; j<arr.length; j++){
                if(arr[j] == largest){
                    arr[j] = Integer.MIN_VALUE;
                }
            }
        }
        return NthLargestElement;
    }
}

*/

// what is the time complexity of the above code?
// the time complexity of the above code is O(n^2) because we are iterating over the array n times and in each iteration, we are iterating over the array to find the largest element.

// how can we optimize the above code?
// we can optimize the above code by using a priority queue. we can insert all the elements of the array into the priority queue and then remove the elements from the priority queue n times to get the Nth largest element.
// the time complexity of this approach is O(nlogn) because we are inserting n elements into the priority queue and removing n elements from the priority queue. the time complexity of inserting and removing an element from the priority queue is O(logn). so the overall time complexity is O(nlogn).
// doesn't quicksort also have a time complexity of O(nlogn)?
// yes, quicksort has a time complexity of O(nlogn) but the above approach is better than quicksort because we are not sorting the entire array. we are just finding the Nth largest element. so the above approach is more efficient than quicksort.
// can this be done in O(n) time complexity?
// yes, this can be done in O(n) time complexity by using the quickselect algorithm. the quickselect algorithm is similar to the quicksort algorithm but instead of sorting the entire array, we just partition the array based on the pivot element and find the Nth largest element. the time complexity of the quickselect algorithm is O(n) on average. so the quickselect algorithm is the most efficient way to find the Nth largest element in an array without sorting the array.

// quickselect algorithm

// 'NOTE: This algorithm is not yet covered in the course. It is for future reference.'

class NthLargestElementWithoutSorting{
    public static void main(String[] args){
        int[] arr = {2, 4, 5, 1, 7, 8, 6, 3};
        int n = 3;
        int NthLargestElement = NthLargestElement(arr, n);
        System.out.println(NthLargestElement);
    }

    public static int NthLargestElement(int[] arr, int n){
        return quickSelect(arr, 0, arr.length-1, n);
    }

    public static int quickSelect(int[] arr, int low, int high, int n){
        if(low == high){
            return arr[low];
        }
        int pivotIndex = partition(arr, low, high);
        int k = pivotIndex - low + 1;
        if(n == k){
            return arr[pivotIndex];
        }else if(n < k){
            return quickSelect(arr, low, pivotIndex-1, n);
        }else{
            return quickSelect(arr, pivotIndex+1, high, n-k);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low;
        for(int j=low; j<high; j++){
            if(arr[j] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}