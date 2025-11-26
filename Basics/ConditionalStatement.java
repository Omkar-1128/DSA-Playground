package Basics;
import java.util.*;

public class ConditionalStatement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Positive negative number
         
        // System.out.println("Enter the number: ");
        // int n = sc.nextInt();
        // if(n == 0) {
        //     System.out.println("Given number is Zero.");
        // } else if(n < 0) {
        //     System.out.println("Given number is negative.");
        // } else {
        //     System.out.println("Given number is Positive.");
        // }

        //You have a fever if your temperature is above 100 and otherwise prints You don't have a fever

        // double temp = 103.5;

        // if (temp >= 100) {
        //     System.out.println("You have a fever");
        // } else {
        //     System.out.println("You don't have a fever");
        // }

        // input week number(1-7) and print day of week name


        // int number = sc.nextInt();

        // switch (number) {
        //     case 1:
        //         System.out.println("Monday.");
        //         break;
        //     case 2:
        //         System.out.println("Tuesday.");
        //         break;
        //     case 3: 
        //         System.out.println("Wednesday.");
        //         break;
        //     case 4:
        //         System.out.println("Thursday.");
        //         break;
        //     case 5:
        //         System.out.println("Friday");
        //         break;
        //     case 6:
        //         System.out.println("Saturday."); 
        //         break;
        //     case 7:
        //         System.out.println("Sunday");
        //         break;                   
        //     default:
        //         System.out.println("Invalid Input");
        //         break;
        // }


        // Leap year or not

        System.out.println("Enter Year: ");
        int year = sc.nextInt();

        if(year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Leap Year.");
                } else {
                    System.out.println("Not Leap Year.");
                }
            } else {
                System.out.println("Leap Year.");
            }
        } else {
            System.out.println("Not leap year.");
        }
    sc.close();;
    }
}
