package PQFIles;
public class RecursionPQ {

    // : For a given integer array of size N. You have to find all the occurrences
    // (indices) of a given element (Key) and print them. Use a recursive function
    // to solve this
    // problem.
    public static void numberOccur(int arr[], int key, int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        numberOccur(arr, key, i + 1);
    }

    // You are given a number (eg - 2019), convert it into a String of english like
    // “two zero one nine”. Use a recursive function to solve this problem.
    // NOTE - The digits of the number will only be in the range 0-9 and the last
    // digit of a number
    // can’t be 0.

    public static void convertNumber(int n, String str, String arr[]) {
        if (n <= 0) {
            return;
        }
        convertNumber(n / 10, str, arr);
        int unit = n % 10;
        str += (arr[unit] + " ");
        System.out.print(str);
    }

    // Length of string using recursion
    public static int StringLength(StringBuilder sb) {
        if(sb.toString().equals("")) {
            return 0;
        }
        return 1 + StringLength(sb.deleteCharAt(0));
    }

    //  We are given a string S, we need to find the count of all contiguous substrings
    // starting and ending with the same character

    public static int contiguousSubString(StringBuilder sb , int start ,  int end) {
        if(start >= sb.length()) {
            return 0;
        } else if (end >= sb.length()) {
            return contiguousSubString(sb, start + 1, start + 1);
        }
        int count = 0;
        if(sb.charAt(start) == sb.charAt(end)) {
            count = 1;
        } 

        return count + contiguousSubString(sb, start, end + 1);
    }

    // tower of hanoi
    public static void towerOfHanoi(int n , String src , String help , String des) {
        if(n == 1) {
            System.out.println("Transfer from " + src + " to " + des);
            return;
        }  

        towerOfHanoi(n - 1, src, des, help);
        System.out.println("Transfer from " + src + " to " + des);
        towerOfHanoi(n - 1, help, src, des);
    }

    public static void main(String[] args) {
        // int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // int key = 2;
        // numberOccur(arr, key, 0);

        // String numWords[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        // convertNumber(254187955, "", numWords);

        // System.out.println(StringLength(new StringBuilder("Lightning Ace")));

        // StringBuilder sb = new StringBuilder("abcab");

        // System.out.println(contiguousSubString(sb , 0, 0));

       towerOfHanoi(3, "A", "B", "C");
    }
}
