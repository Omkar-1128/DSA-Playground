package Arrays;
// import java.util.Arrays;
// import java.util.Collections;

public class Sorting {

    // Bubble Sorting  // tc = O(n2)

    // public static void BubbleSort(int arr[]) {
    //     int n = arr.length;
    //     for(int i = 0 ; i < n - 1 ; i++) {
    //         int swap = 0;
    //         for(int j = 0 ; j < n - 1 - i ; j++) {
    //             if(arr[j] > arr[j + 1]) {
    //                 int temp = arr[j];
    //                 arr[j] = arr[j + 1];
    //                 arr[j + 1] = temp;
    //                 swap++;
    //             }
    //         }
    //         System.out.println(swap);
    //     }
    // }

    // Optimal Bubble sort approch // tc(best case) = O(n)
    // public static void BubbleSort(int arr[]) {
    //     int n = arr.length;
    //     for(int i = 0 ; i < n - 1 ; i++) {
    //         boolean swaped = false;
    //         int swap = 0;
    //         for(int j = 0 ; j < n - 1 - i ; j++) {
    //             if(arr[j] > arr[j + 1]) {
    //                 int temp = arr[j];
    //                 arr[j] = arr[j + 1];
    //                 arr[j + 1] = temp;
    //                 swap++;
    //                 swaped = true;
    //             }
    //         }
    //         if(swaped == false) {
    //             break;
    //         }
    //         System.out.println(swap);
    //     }
    // }

    // Selection sort

    // public static void SelectionSort(int arr[]) {
    //     int n = arr.length;

    //     for(int i = 0 ; i < n - 1; i++) {
    //         int minIndex = i;
    //         for(int j = i + 1; j < n; j++) {
    //             if(arr[minIndex] > arr[j]) {
    //                 minIndex = j;
    //             }
    //         }
    //         int temp = arr[minIndex];
    //         arr[minIndex] = arr[i];
    //         arr[i] = temp;
    //     }
    // }

    // Insertion Sort 

    // public static void InsertionSort(int arr[]) {
    //     for(int i = 1 ; i < arr.length ; i++) {
    //         int current = arr[i];
    //         int previous = i - 1;
    //         while (previous >= 0 && current < arr[previous]) {
    //             arr[previous + 1] = arr[previous];
    //             previous--;
    //         }

    //         arr[previous + 1]  = current;
    //     }
    // }

    // Counting Sort

    // public static void CountingSort(int arr[]) {
    //     int largest = Integer.MIN_VALUE;
    //     for(int i = 0 ; i < arr.length ; i++) {
    //         largest = Math.max(largest, arr[i]);
    //     }

    //     int countArr[] = new int[largest + 1];
    //     for(int i = 0 ; i < arr.length ; i++) {
    //         countArr[arr[i]]++;
    //     }

    //     int j = 0;
    //     for(int i = 0 ; i < countArr.length ; i++) {
    //         while (countArr[i] > 0) {
    //             arr[j] = i;
    //             j++;
    //             countArr[i]--;
    //         }
    //     }
    // }

    // All Sorting in decending order 

    // public static void BubbleSort(int arr[]) {
    //     int n = arr.length;
    //     for(int i = 0 ; i < n - 1; i++) {
    //         for(int j = i + 1 ; j < n ; j++) {
    //             if(arr[i] < arr[j]) {
    //                 int temp = arr[i];
    //                 arr[i] = arr[j];
    //                 arr[j] = temp;
    //             }
    //         }
    //     }
    // }

    // public static void SelectionSort(int arr[]) {
    //     int n = arr.length;
    //     for (int i = 0 ; i < n - 1 ; i++) {
    //         int min = i;
    //         for(int j = i + 1 ; j < n ; j++) {
    //             if(arr[j] > arr[min]) {
    //                 min = j;
    //             }
    //         }
    //         int temp = arr[min];
    //         arr[min] = arr[i];
    //         arr[i] = temp;
    //     }
    // }

    // public static void InsertionSort(int arr[]) {
    //     int n = arr.length;
    //     for(int i = 1 ; i < n ; i++) {
    //         int curr = arr[i];
    //         int prev = i - 1;
    //         while (prev >= 0 && curr > arr[prev]) {
    //             arr[prev + 1] = arr[prev];
    //             prev--;
    //         }

    //         arr[prev + 1] = curr;
    //     }
    // }

    public static void CountingSort(int arr[]) {
        int largest = 0;
        for(int i = 0 ;i < arr.length ; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int countArr[] = new int[largest + 1];

        for(int i = 0 ; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        int j = 0;
        for(int i = countArr.length - 1 ; i >= 0; i--) {
            while (countArr[i] > 0) {
                arr[j] = i;
                j++;
                countArr[i]--;
            }
        }
    }

    public static void PrintArr(int arr[]) {
        for(int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        // int arr[] = {3,6,2,1,8,7,4,5,3,1};
        // BubbleSort(arr);
        // SelectionSort(arr);
        // InsertionSort(arr);


        // Inbuilt Sort
        // Arrays.sort(arr);
        // Arrays.sort(arr , 0 , 3);  // start element and end element

        // Arrays.sort(arr , Collections.reverseOrder());  // for using collection we have to declare elements by Integer not int
        // Arrays.sort(arr , 0 , 3 , Collections.reverseOrder());  // With start and end index

        // CountingSort(arr);

        int arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        // BubbleSort(arr);
        // SelectionSort(arr);

        // InsertionSort(arr);
        CountingSort(arr);
        PrintArr(arr);
    }
}
