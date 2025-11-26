public class DivideAndConqure {
    // Merge Sort Algorithm
    // time complexity = O(nlogn) and space complexity = O(n)

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2; // new mid formula for larger calculations
        mergeSort(arr, 0, mid); // Left part of array
        mergeSort(arr, mid + 1, ei); // Right part of array

        merge(arr, si, mid, ei); // to merge the both the parts
    }

    public static void merge(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei - si + 1];

        int i = si; // pointer to travel the left array
        int j = mid + 1; // pointer to travel the right array
        int k = 0; // pointer to travel the temp array

        // sorting and merge the arrays
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // leftOver the element for the 1st sorting part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // leftOver the elements for the second sorting part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // taansfer the values from temp array to the original array

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // Quick Sort alogorithm
    // Average = O(nlogn) worst = O(n2) SP = O(1)
    public static void QuickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // Last index
        int pidx = Partition(arr, si, ei);
        QuickSort(arr, si, pidx - 1);
        QuickSort(arr, pidx + 1, ei);
    }

    public static int Partition(int arr[], int si, int ei) {
        int i = si - 1;
        int pivot = arr[ei];

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot to its original position
        i++;
        arr[ei] = arr[i];
        arr[i] = pivot;

        return i;
    }

    // Search in Rotated sorted array
    // Using Recursion
    public static int Search(int arr[], int si, int ei, int target) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {

            // On line 1
            // case: a
            if (arr[mid] > target && arr[si] <= target) { // on left side
                return Search(arr, si, mid - 1, target);
            // case: b
            } else {  // on right side
                return Search(arr, mid + 1, ei, target);
            }
        } else {

            // On line 2
            // case: c
            if (arr[mid] < target && arr[ei] >= target) {  // left side
                return Search(arr, mid + 1, ei, target);
            // case: d    
            } else {  // right side
                return Search(arr, si, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 9 , 6 , -1 , -5 , 3 , 9};
        // mergeSort(arr, 0, arr.length - 1);
        // QuickSort(arr, 0, arr.length - 1);
        // PrintArray(arr);

        int arr[] = { 5, 6, 7, 8, 1, 2, 3 };
        int target = 5;
        System.out.println(Search(arr, 0, arr.length - 1, target));
    }
}
