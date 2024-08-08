// given an integer array 'a' return the prefix sum array
// prefix sum array is an array where the ith element is the sum of the first i elements of the input array
// implement using function
// also calculate the suffix sum array
// suffix sum array is an array where the ith element is the sum of the last i elements of the input array
// also calculate the suffix sum using formula suffixSum = totalSum - prefixSum + a[i]
// also solve another problem: given an array of integers of size n, answer q queriess where you need to print the sum of values in the range l to r (both inclusive)
// implement using function
// also take input n from user and check if the array can be partitioned into equal sum subarrays. Implement using function



import java.util.Scanner;
public class PrefixSumSuffixSum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[] prefixSum = prefixSum(a);
        for(int i=0;i<n;i++){
            System.out.print(prefixSum[i]+" ");
        }
        System.out.println();
        int[] suffixSum = suffixSum(a);
        for(int i=0;i<n;i++){
            System.out.print(suffixSum[i]+" ");
        System.out.println();
        }
        System.out.println("Enter the number of queries");
        int q = sc.nextInt();
        while(q-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int sum = sumInRange(a,l,r);
            System.out.println(sum);
        }
        System.out.println("Enter the array index n to check if the array can be partitioned into equal sum subarrays");
        n = sc.nextInt();
        System.out.println(canPartition(a,n));
        sc.close();


    }
    public static int[] prefixSum(int[] a){
        int n = a.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = a[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + a[i];
        }
        return prefixSum;
    }
    public static int[] suffixSum(int[] a){
        int n = a.length;
        int[] suffixSum = new int[n];
        suffixSum[n-1] = a[n-1];
        for(int i=n-2;i>=0;i--){
            suffixSum[i] = suffixSum[i+1] + a[i];
        }
        return suffixSum;
    }

    public static int[] suffixSumUsingPrefixSum(int[] a){
        int n = a.length;
        int[] suffixSum = new int[n];
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += a[i];
        }
        int[] prefixSum = prefixSum(a);
        for(int i=0;i<n;i++){
            suffixSum[i] = totalSum - prefixSum[i] + a[i];
        }
        return suffixSum;
    }
    static int sumInRange(int[] a, int l, int r){
        int[] prefixSum = prefixSum(a);
        if(l==0){
            return prefixSum[r];
        }
        return prefixSum[r] - prefixSum[l-1];
    }

    static int ArraySum(int[] a){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        return sum;
    }

    static boolean canPartition(int[] a, int n){
        int[] prefixSum = prefixSum(a);
        int[] suffixSum = suffixSum(a);
        for(int i=0;i<n;i++){
            if(prefixSum[i] == suffixSum[i]){
                return true;
            }
        }
        return false;
    }

}