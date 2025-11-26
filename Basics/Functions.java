package Basics;
// import java.util.*

public class Functions {

    // Prime Number

    // public static boolean isPrime(int n) {
    //     if( n == 2 ) {
    //         return true;
    //     }

    //     for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
    //         if( n % i == 0) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // public static void printPrimeRange(int n) {
    //     for(int i = 2 ; i <= n; i++) {
    //         if(isPrime(i) == true) {
    //             System.out.print(i + " ");
    //         } 
    //     }
    // }

    // Binary To Decimal

    // public static int binToDec(int binNum) {
    //     int pow = 0;
    //     int decNum = 0;

    //     while (binNum > 0) {
    //         int lastDigit = binNum % 10;
    //         decNum = decNum + (lastDigit * (int)Math.pow(2, pow));
    //         binNum /= 10;
    //         pow++;
    //     }

    //     return decNum;
    // }

    // Decimal to Binary

    // public static int decToBin(int decNum) {
    //     int pow = 0;
    //     int binNum = 0;

    //     while (decNum > 0) {
    //         int rem = decNum % 2;
    //         binNum = binNum + (rem * (int)Math.pow(10, pow));
    //         pow++;
    //         decNum /= 2;
    //     }

    //     return binNum;
    // }

    // Write a Java method to compute the average of three numbers..

    // public static double Avg(double a , double b , double c) {
    //     return (a + b + c) / 3;
    // }

    //     Write a method named isEven that accepts an int argument. The method
    // should return true if the argument is even, or false otherwise. Also write a program to test your
    // method.

    // public static boolean isEven(int Num) {
    //     if(Num % 2 == 0) {
    //         return true;
    //     }
    //     return false;
    // }

    // Write a Java program to check if a number is a palindrome in Java?
    
    // public static void palindromeTest(int Num) {
    //     int OriginalNum = Num;
    //     int reverse = 0;
    //     while (Num > 0) {
    //         int lastDigit = Num % 10;
    //         reverse = (reverse * 10) + lastDigit;
    //         Num /= 10;
    //     }
        
    //     if(OriginalNum == reverse) {
    //         System.out.println("Palindrom");
    //     } else {
    //         System.out.println("Not Palindrom");
    //     }
    // }

    // Write a Java method to compute the sum of the digits in an integer

    // public static int DigitSum(int Num) {
    //     int sum = 0;
    //     while (Num > 0) {
    //         int lastDigit = Num % 10;
    //         sum += lastDigit;
    //         Num /= 10;
    //     }

    //     return sum;
    // }

    public static void main(String[] args) {
    }
}
