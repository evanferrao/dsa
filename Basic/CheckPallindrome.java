// write a code in java to check palindrome number

import java.util.Scanner;
class CheckPalindrome{
    public static void main(String args[]){
        int n, sum = 0, r, temp;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        n = scanner.nextInt();
        scanner.close();
        temp = n;
        while(n > 0)
        {
            r = n % 10;
            sum = (sum*10) + r;
            n = n/10;
        }
        if(temp == sum)
        {
            System.out.println("Given number is Palindrome");
        }
        else
        {
            System.out.println("Given number is not Palindrome");
        }
    }
}