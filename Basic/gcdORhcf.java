// write a code to find gcd using euclidean algorithm in a function

import java.util.Scanner;

class gcdORhcf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to find their GCD: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.close();
        System.out.println("GCD of " + num1 + " and " + num2 + " is " + findGCD(num1, num2));
    }

    public static int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return findGCD(num2, num1 % num2);
    }
}