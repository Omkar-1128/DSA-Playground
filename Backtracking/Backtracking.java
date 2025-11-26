package Backtracking;

public class Backtracking {

    public static void PrintArray(int arr[]) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Backtracking in arrays
    public static void ArrayBT(int arr[] , int i , int val) {
        if(i == arr.length) {
            PrintArray(arr);
            System.out.println();
            return;
        }

        arr[i] = val;
        ArrayBT(arr, i + 1 , val + 1);
        arr[i] = arr[i] - 2;
    }

    // find subsets
    public static void findSubsets(String str , String ans , int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        findSubsets(str, ans + str.charAt(i) , i + 1);
        findSubsets(str, ans, i + 1);

    }

    // Find permutations
    public static void FindPermutations(String str , String ans) {
        // Base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recursion

        for (int i = 0 ; i < str.length() ; i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1 , str.length());
            FindPermutations(newStr, ans + currChar);
        }

        // for(int i = 0 ; i < str.length() ; i++) {
        //     FindPermutations(str.substring(0, i) + str.substring(i + 1), ans + str.charAt(i));
        // }
    }

    // Grid Ways

    public static int GridWays(int i , int j , int n , int m ) {
        // base case
        if(i == n - 1 && j == m - 1) { // Condition for last cell
            return 1;
        } else if (i == n || j == m) { // boundry condition
            return 0;
        }

        // Recursion
        return GridWays(i, j + 1, n, m) + GridWays(i + 1, j, n, m);
    }

    // Grid ways Math Trick using permutations Formula
    // Linear time complexity
    public static int fact(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // recursion
        return n * fact(n - 1);
    }

    public static int GridWaysOptimal(int n , int m) {
        return fact(n - 1 + m - 1) / (fact(n - 1) * fact(m - 1)); // permutation formula without repeatition
    }

    public static void main(String[] args) {
        // int arr[] = new int[5];

        // ArrayBT(arr, 0, 1);

        // PrintArray(arr);

        // String myString = "abc";
        // findSubsets(myString, "", 0);
        // FindPermutations(myString, "");

        int n = 3 , m = 3;
        // System.out.println(GridWays(0, 0, n, m));
        System.out.println(GridWaysOptimal(n, m));
    }
}
