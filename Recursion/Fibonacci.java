// write code to find the nth fibonacci number using recursion
import java.util.Scanner;
public class Fibonacci{
    static int first=0,second=1,next=0;
    static void printFibonacci(int count){
        if(count>0){
            next = first + second;
            first = second;
            second = next;
            System.out.print(" "+next);
            printFibonacci(count-1);

            // can you assign proper variable names to n1, n2 and n3?
            // n1 should be named as first, n2 as second and n3 as next
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms: ");
        int count = sc.nextInt();
        System.out.print(first+" "+second);//printing 0 and 1
        printFibonacci(count-2);//n-2 because 2 numbers are already printed
        sc.close();
    }
}