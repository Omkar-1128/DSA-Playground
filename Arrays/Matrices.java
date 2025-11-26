package Arrays;
// import java.util.Scanner;
import java.util.Arrays;

public class Matrices {

    // public static boolean Search(int matrix[][] , int key) {
    //     for(int i = 0 ; i < matrix.length ; i++) {
    //         for(int j = 0 ; j < matrix[0].length ; j++) {
    //             if(matrix[i][j] == key) {
    //                 System.out.println("Key Found");
    //                 return true;
    //             }
    //         }
    //     }
    //     System.out.println("Key Not Found");
    //     return false;
    // }

    // public static void LargestSmallest(int matrix[][]) {
    //     int largest = Integer.MIN_VALUE;
    //     int smallest = Integer.MAX_VALUE;
    //     for (int i = 0 ; i < matrix.length ; i++) {
    //         for(int j = 0; j < matrix[0].length; j++) {
    //             largest = Math.max(largest, matrix[i][j]);
    //             smallest = Math.min(smallest, matrix[i][j]);
    //         }
    //     }
    //     System.out.println("Largest Value: " + largest);
    //     System.out.println("Smallest Value: " + smallest);
    // }


    // Spiral Matrix //

    public static void SpiralMatrix(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int StartRow = 0, EndRow = n- 1 , StartCol = 0 , EndCol = m - 1;

        while (StartRow <= EndRow && StartCol <= EndCol) {
            // top
            for(int i = StartCol ; i <= EndCol ; i++) {
                System.out.print(arr[StartRow][i] + " ");
            }
            //right
            for(int i = StartRow + 1 ; i <= EndRow ; i++) {
                System.out.print(arr[i][EndCol] + " ");
            }
            // buttom
            for(int i = EndCol - 1 ; i >= StartCol ; i--) {
                if(StartRow == EndRow) {
                    break;
                }
                System.out.print(arr[EndRow][i] + " ");
            }
            // left
            for(int i = EndRow - 1 ; i > StartRow ; i--) {
                if(StartCol == EndCol) {
                    break;
                }
                System.out.print(arr[i][StartCol] + " ");
            }

            StartRow++;
            EndRow--;
            StartCol++;
            EndCol--;
        }
    }

    // * Diagonal Sum * //

    public static void DiagonalSum(int arr[][]) {
        int n = arr.length;
        int sum = 0;

        for(int i = 0 ; i < n ; i++) {
            sum += arr[i][i];

            if(i != n - 1 - i) {
                sum += arr[i][n - 1 - i];
            }
        }

        System.out.println(sum);
    }

    // Search in sorted matrix

    public static void stairCaseSearch(int matrix[][] , int key) {
        // int n = matrix.length, m = matrix[0].length;
        // int i = 0;
        // int j = m - 1;
        
        // while (i < n && j >= 0) {
        //     if(matrix[i][j] == key) {
        //         System.out.println("Found at" + "(" + i + "," + j + ")");
        //         return;
        //     } else if(matrix[i][j] > key) {
        //         j--;
        //     } else if(matrix[i][j] < key) {
        //         i++;
        //     }
        // }

        // System.out.println("Not Found");

        int n = matrix.length, m = matrix[0].length;
        int i = n - 1;
        int j = 0;

        while (i >= 0 && j < m) {
            if(matrix[i][j] == key) {
                System.out.println("Found at" + "(" + i + "," + j + ")");
                return;
            } else if (matrix[i][j] < key) {
                j++;
            } else {
                i--;
            }
        }

        System.out.println("Not Found");
    }

    // Question 1 : Print the number of 7’s that are in the 2d array.
    // Example :
    // Input - int[][] array = { {4,7,8},{8,8,7} };
    // Output - 2

    public static void Example1(int matrix[][] , int key) {
        int count = 0;
        for(int i = 0 ; i < matrix.length  ;i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == key) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    // Question 2 : Print out the sum of the numbers in the second row of the “nums” array.
    // Example :
    // Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
    // Output - 18

    public static void Example2(int matrix[][]) {
        int sum = 0;
        for(int j = 0 ; j < matrix[0].length; j++) {
            sum += matrix[1][j];
        }
        System.out.println("Sum of second row: " + sum);
    }

    // Write a program to Find Transpose of a Matrix

    public static void TransposeM(int matrix[][]) {
        int Transpose[][] = new int[matrix[0].length][matrix.length];
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
               Transpose[j][i] = matrix[i][j];
            }
            System.out.println();
        }

        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
               System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0 ; i < Transpose.length ; i++) {
            for(int j = 0 ; j < Transpose[0].length ; j++) {
               System.out.print(Transpose[i][j] + " ");
            }
            System.out.println();
        }

    }

    // 3 sum

    public static void ThreeSum(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);

        for(int i = 0 ; i < n - 1 ; i++) {
            int left = i + 1;
            int right = n - 1;

            if(i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    System.out.println("[" + arr[i] + "," + arr[left] + "," + arr[right] + "]");

                    while (left < right &&  arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    // transpose of square matrix;

    public static void TransposeSquare(int matrix[][]) {
        int n = matrix.length;
        for(int i = 0; i < n ; i++) {
            for(int j = i + 1 ; j < n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
               System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        
    }

    public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        // Scanner sc = new Scanner(System.in);

        // int matrix[][] = {{1 , 2 , 3} , {4 , 5 , 6} , {7 , 8 , 9}};

        // for(int i = 0; i < matrix.length ; i++) {
        //     for(int j = 0 ; j < matrix[0].length ; j++) {
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        // for(int i = 0; i < matrix.length ; i++) {
        //     for(int j = 0 ; j < matrix[0].length ; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // Search(matrix, 10);
        // LargestSmallest(matrix);


        // *** Spiral Matrix *** //

        // int arr[][] = {{1 , 2 , 3 , 4} , {5 , 6 , 7 , 8} , {9 , 10 , 11 , 12} , {13 , 14 , 15 , 16}};

        // SpiralMatrix(arr);

        // Diagonal Sum

        // DiagonalSum(matrix);

        // Search in sorted Matrix

        int matrix[][] = {{10 , 20 , 30 , 40} , {15 , 25 , 35 , 45} , {27 , 29 , 37 , 48} , {32 , 33 , 39 , 50}};
        // int key = 10;
        // stairCaseSearch(matrix , key);

        // int[][] array = { {4,7,8},{8,8,7} };
        // int key = 8;
        // Example1(array , key);

        // int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        // Example2(nums);

        // int[][] array = { {4,7,8},{8,8,7} };
        // TransposeM(array);

        // int arr[] = {-1,0,1,2,-1,-4};
        // ThreeSum(arr);

        TransposeSquare(matrix);
    }
}