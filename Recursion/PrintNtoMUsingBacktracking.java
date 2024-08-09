// write a code to print N to one using recursion and function in java using backtracking

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
       int n = 8;
       func(n,4);
    }
}