public class Recursion {

    // Print number in decreasing order
    public static void PrintDec(int n) {
        if(n > 0) {
            System.out.print(n + " ");
        } else {
            return;
        }
        
        PrintDec(n - 1);
    }

    // Print number in increasing order
    public static void PrintInc(int n) {
        if(n == 1) {
            System.out.print(1 + " ");
            return;
        }
        PrintInc(n - 1);
        System.out.print(n + " ");
    }

    // Factorial of n
    public static int Factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

    // Sum of N natural numbers
    public static int Sum(int n) {
        if(n == 0) {
            return 0;
        }
        return n + Sum(n - 1);
    }

    // Fibonacci series
    public static int Fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        } 
        
        // int fnm1 = Fibonacci(n - 1);
        // int fnm2 = Fibonacci(n - 2);
        // int fn = fnm1 + fnm2;
        // return fn;

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    // Check the array is sorted or not
    public static boolean isSorted(int arr[] , int i) {
        if(i == arr.length - 1) {
            return true;
        }
        if(arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    // First occurence of element in an array
    public static int FirstOccur(int arr[] , int i , int key) {
        if(arr.length-1 == i) {
            return -1;
        }

        if(arr[i] == key) {
            return i;
        }

        return FirstOccur(arr, i + 1, key);
    }

    // Last Occurance 
    public static int LastOccur(int arr[] , int i , int key) {
        if(arr.length == i) {
            return -1;
        }
        int newi = LastOccur(arr, i + 1, key);
        if(newi != -1) {
            return newi;
        }
        if(arr[i] == key) {
            return i;
        }
        return newi;
    }

    // Power function
    // public static int Power(int x , int n) {
    //     if(n == 0) {
    //         return 1;
    //     }
    //     return x * Power(x, n - 1);
    // }

    // optimized power function
    public static int power(int x , int n) {
        if(n == 0) {
            return 1;
        }
        int hPower = power(x, n / 2);
        
        int fullPower = hPower * hPower;
        if(n % 2 != 0) {
            fullPower = x * fullPower;
        }

        return fullPower;
        
    }

    // Tiling
    public static int Tiles(int n) { // 2 x n = floor size
        // if(n == 0 || n == 1) {
        //     return 1;
        // }

        // Verticle Choice
        // int fnm1 = Tiles(n - 1);

        // Horizontal Choice
        // int fnm2 = Tiles(n - 2);

        // return fnm1 + fnm2;

        if(n == 0 || n ==1) return 1;
        return Tiles(n - 1) + Tiles(n - 2);
    }
    public static void main(String[] args) {
        // PrintDec(10);
        // PrintInc(10);

        // System.out.println(Factorial(5));
        // System.out.println(Sum(2));
        System.out.println(Fibonacci(25));

        // int arr[] = {1, 2 ,3 , 4 , 4 , 6 , 4};
        // System.out.println(isSorted(arr, 0));

        // System.out.println(FirstOccur(arr, 0, 4));
        // System.out.println(LastOccur(arr, 0, 4));

        // System.out.println(Power(5, 2));
        // System.out.println(power(5, 2));

    }
}
