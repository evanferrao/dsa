// write a code to print N to one using recursion and function in java using backtracking
import java.util.Scanner;
class PrintNtoMUsingBacktracking {
    
    static void func(int i, int n){
        
            // Base Condition.
            if(i<n) return;
            
            // Function call to print(n-1) integers.
            func(i-1,n);
            System.out.println(i);

    }
    public static void main(String[] args) {

       // Here, let’s take the value of n to be 4.
        System.out.println("Enter the value of n (Starting Variable): ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the value of m (Ending Variable): ");
        int m = sc.nextInt();
        //int n = 8;
        func(m,n);
        sc.close();
    }
}