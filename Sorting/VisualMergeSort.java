public class VisualMergeSort {
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
    static String BLUE = "\u001B[34m";
    static int id = 0;

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        printArray(array);

        // Initialize ID and call mergeSort
        mergeSort(array, 0, array.length - 1, id);

        System.out.println("Sorted array:");
        printArray(array);
    }

    // Method to perform merge sort with ID parameter
    public static void mergeSort(int[] array, int left, int right, int currentId) {
        if (left < right) {
            int mid = (left + right) / 2;
            System.out.printf("Dividing array from index %d to %d and mid %d\n", left, right, mid);
            // System.out.printf("Current subarray: ");
            // printArray(array, left, right);

            // Recursively sort the first and second halves
            int newId = currentId + 1;
            System.out.printf("%sCalling the first mergeSort with left = %d and right = %d with ID %d %s\n", YELLOW, left, mid, newId, RESET);
            System.out.printf("First subarray: ");
            printArray(array, left, mid);
            mergeSort(array, left, mid, newId);

            System.out.printf("%sCalling the second mergeSort with left = %d and right = %d with ID %d %s\n", BLUE, mid + 1, right, newId , RESET);
            System.out.printf("Second subarray: ");
            printArray(array, mid + 1, right);
            mergeSort(array, mid + 1, right, newId);

            // Merge the sorted halves
            merge(array, left, mid, right);
        } else {
            System.out.printf("%sBase condition reached with left = %d and right = %d %s\n", GREEN, left, right, RESET);
        }
    }

    // Method to merge two sorted subarrays
    public static void merge(int[] array, int left, int mid, int right) {
        System.out.printf("Merging subarrays from index %d to %d and %d to %d\n", left, mid, mid + 1, right);
        System.out.printf("Subarrays before merge: ");
        printArray(array, left, mid);
        printArray(array, mid + 1, right);

        // Sizes of the two subarrays to merge
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Display temporary arrays
        System.out.printf("Left array: ");
        printArray(leftArray);
        System.out.printf("Right array: ");
        printArray(rightArray);

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            System.out.printf("Placing %d at index %d\n", array[k], k);
            k++;
        }

        // Copy remaining elements of leftArray[], if any
        while (i < n1) {
            array[k] = leftArray[i];
            System.out.printf("Placing %d at index %d\n", array[k], k);
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[], if any
        while (j < n2) {
            array[k] = rightArray[j];
            System.out.printf("Placing %d at index %d\n", array[k], k);
            j++;
            k++;
        }

        // Display the merged array
        System.out.printf("Merged array from index %d to %d: ", left, right);
        printArray(array, left, right);
    }

    // Utility method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Utility method to print a specific portion of the array
    public static void printArray(int[] array, int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
