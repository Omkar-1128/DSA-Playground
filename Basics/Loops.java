package Basics;
import java.util.*;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // while (true) {
        //     System.out.print("Enter Number: ");
        //     int n = sc.nextInt();
        //     if(n % 10 == 0) {
        //         System.out.println("You exit the loop");
        //         break;
        //     }
        //     System.out.println("Your number is: " + n);
        // }

        // for(int i = 1; i <= 5 ; i++) {
        //     if(i == 3) {
        //         continue;
        //     }
        //     System.out.println(i);
        // }

        //  while (true) {
        //     System.out.print("Enter Number: ");
        //     int n = sc.nextInt();
        //     if(n % 10 == 0) {
        //         continue;
        //     }
        //     System.out.println("Your number is: " + n);
        // }

        // Prime Number

        // System.out.println("Enter Number: ");
        // int n = sc.nextInt();
        // if (n == 2) {
        //     System.out.println("The number is prime");
        // } else {
        //     boolean isPrime = true;
        //     for(int i = 2 ; i <= Math.sqrt(n); i++) {
        //         if(n % i == 0) {
        //             isPrime = false;
        //         }
        //     }

        //     if(isPrime) {
        //         System.out.println("The number is prime.");
        //     } else {
        //         System.out.println("The number is not prime.");
        //     }
        // }


        // for(int i=0; i<5; i++) {
        //     System.out.println("Hello");
        //     i+=2;
        // }

        //Write a program that reads a set of integers, and then prints the sum of the even and odd integers

        int a = 1;
        while (a == 1) {
            System.out.println("Enter Number: ");
            int n = sc.nextInt();
            int evenSum = 0;
            int oddSum = 0;
            for (int i = 0 ; i <= n; i++) {
                if(i % 2 == 0) {
                    evenSum += i;
                } else {
                    oddSum += i;
                }
            }
            System.out.println("Even Sum => " + evenSum);
            System.out.println("Odd Sum => " + oddSum);

            System.out.println("Do you want to continue: " + "y/n");
            char ch = sc.next().charAt(0);
            if(ch == 'y') {
                a = 1;
            } else {
                a = 0;
            }
        }
        
        
        // foctorial 

        // System.out.println("Enter Number: ");
        // int n = sc.nextInt();
        // int foctorial = 1;

        // if(n == 0) {
        //     foctorial = 1;
        // } else {
        //     for (int i = 1 ; i <= n ; i++) {
        //         foctorial = foctorial * i;
        //     }
        // }

        // System.out.println("Factorial: " + foctorial);

        // Write a program to print the multiplication table of a number N, entered by the user.
        // System.out.println("Enter the Number: ");
        // int n = sc.nextInt();

        // for(int i = 1 ; i <= 10 ; i++) {
        //     System.out.println(n + " * " + i  + " = " + (n * i));
        // }
        
        sc.close();
    }
}
