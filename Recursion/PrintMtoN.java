import java.util.Scanner;

class PrintMtoN {
    
    static void func(int i, int n){
        
            // Base Condition.
            if(i<n) return;
            System.out.println(i);

            // Function call to print i till i decrements to 1.
            func(i-1,n);

    }
    public static void main(String[] args) {

       // Here, let’s take the value of n to be 4.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of m (Ending Variable): ");
        int m = sc.nextInt();
        System.out.println("Enter the value of n (Starting Variable): ");
        int n = sc.nextInt();
        //int n = 8;
        func(m,n);
        sc.close();
    }
}