// write a code in java to find the total number of triplets whose sum is equal to a given number using function
import java.util.Scanner;
class TotalNumberOfTripletsWhoseSumIsEqualToX{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of x");
        int x = sc.nextInt();
        System.out.println("The total number of triplets whose sum is equal to "+x+" is "+countTriplets(arr,n,x));
        sc.close();
    }

    static int countTriplets(int arr[],int n,int x){
        int count = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==x){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}