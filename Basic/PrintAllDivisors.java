// write a code in java to print all divisors in o(n ^ 1/2) time complexity using function

import java.util.Scanner;

class PrintAllDivisors{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        printDivisors(n);
    }

    static void printDivisors(int n){
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                System.out.print(i + " ");
                if(i != n / i){
                    System.out.print(n / i + " ");
                }
            }
        }
    }
}