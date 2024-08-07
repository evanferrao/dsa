// write a code in java to find the total number of pairs whose sum is equal to a given number using function
import java.util.Scanner;
class TotalNumberOfParirsWhoseSumIsEqualToX{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of x");
        int x = sc.nextInt();
        System.out.println("The total number of pairs whose sum is equal to "+x+" is "+totalPairs(arr,n,x));
        sc.close();
    }
    public static int totalPairs(int[] arr,int n,int x){
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==x){
                    count++;
                }
            }
        }
        return count;
    }
}