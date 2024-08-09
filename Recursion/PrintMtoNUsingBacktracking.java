import java.util.Scanner;

class PrintMtoNUsingBacktracking {
    
    static void func(int i, int n){
        
            // Base Condition.
            if(i>n) return;
            
            // Function call to print(i+1) integers.
            func(i+1,n);
            System.out.println(i);

    }
    public static void main(String[] args) {

       // Here, let’s take the value of n to be 4.
       //int n = 8;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of m (Ending Variable): ");
        int m = sc.nextInt();
        System.out.println("Enter the value of n (Starting Variable): ");
        int n = sc.nextInt();
        func(n,m);
        sc.close();
    }
}