// write a program to convert decimal number to binary number using funciton

import java.util.Scanner;

public class ConvertToBinary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        String binary = convertToBinary(num);

        System.out.println("Binary number is: " + binary);

        sc.close();

    }

    // for future reference, I do not understand how this works yet.
    // will go through this when I learn recursion.
    public static String RecusiveConvertToBinary(int num) {

        if (num > 0) {
            return convertToBinary(num / 2) + (num % 2);
        }
        return "";

    }

    public static String convertToBinary(int num) {

        String binary = "";

        while (num > 0) {

            binary = binary + (num & 1); //binary = binary + (num % 2);  // or binary += (num & 1)
            num = num >> 1; //num = num / 2;  // or num /= 2

        }
        // note: since we are doing binary = binary + (num % 2);, we have a reverse order
        // if we do binary = (num % 2) + binary; then we will get the correct order
        // but we usually use the += operator to do this which performs binary = binary + (num % 2);

        // so we will reverse the output
        binary = new StringBuilder(binary).reverse().toString();

        return binary;

    }

}



