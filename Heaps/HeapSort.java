package Heaps;

public class HeapSort {

    // //  Heap Sort in ascending order
    // public static void Heapify(int i , int n , int arr[]) { // i -> index , n -> size of heap
    //     int maxIdx = i;
    //     int left = 2 * i + 1;
    //     int right = 2 * i + 2;

    //     if (left < n && arr[maxIdx] < arr[left]) {
    //         maxIdx = left;
    //     }

    //     if (right < n && arr[maxIdx] < arr[right]) {
    //         maxIdx = right;
    //     }

    //     if (maxIdx != i) {
    //         int temp = arr[i];
    //         arr[i] = arr[maxIdx];
    //         arr[maxIdx] = temp;

    //         Heapify(maxIdx, n, arr);
    //     }
    // }

    // public static void heapSort(int arr[]) {   // TC :- O(nlogn)
    //     // for ascending order max heap is required
    //     // Step 1 :- Create Max Heap
    //     int n = arr.length;
    //     // call Heapify for non-left Node or last level nodes
    //     for (int i = n / 2; i >= 0 ; i--) {   // All the non leaft nodes
    //         Heapify(i , n , arr);
    //     }
    //     // Now it is converted into max Heap

    //     // step 2 :- Swap

    //     for (int i = n - 1 ; i >= 1 ; i--) {
    //         // swap (first index element with last index element)
    //         int temp = arr[0];
    //         arr[0] = arr[i];
    //         arr[i] = temp;

    //         Heapify(0, i, arr);  // Fix the heap after swap
    //     }

    // }


    // Heap sort in descending order
    public static void Heapify(int i , int size , int arr[]) {
        int minIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[minIdx] > arr[left]) {
            minIdx = left;
        }

        if (right < size && arr[minIdx] > arr[right]) {
            minIdx = right;
        }

        if (minIdx != i) {
            // Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            Heapify(minIdx, size, arr);
        }
    }

    public static void heapSort(int arr[]) {
        // Step 1 - Convert it into Min Heap
        int n = arr.length;
        for (int i = n / 2 ; i >= 0 ; i--) {
            Heapify(i , n , arr);
        }
        // Min Heap Created

        // Step 2 :- Swap

        for (int i = n - 1 ; i >= 1 ; i--) {
            // Swap (first index element and last index element)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            Heapify(0, i, arr); // To fix the heap
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1 , 2 , 4 , 5 , 3 };
        heapSort(arr);

        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
