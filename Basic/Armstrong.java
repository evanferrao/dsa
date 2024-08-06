// write code to check armstrong number

import java.util.Scanner;

class Armstrong{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to check if it is an Armstrong number or not");
        int num = scanner.nextInt();
        scanner.close();
        int temp = num;
        int sum = 0;
        while(num>0){
            int rem = num%10;
            sum += rem*rem*rem;
            num = num/10;
        }
        if(sum == temp){
            System.out.println("The number is an Armstrong number");
        }
        else{
            System.out.println("The number is not an Armstrong number");
        }
    }
}