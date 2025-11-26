public class dividenconqurePQ {

    // public static void PrintArray(String arr[]) {
    // for (int i = 0; i < arr.length; i++) {
    // System.out.print(arr[i] + " ");
    // }
    // }

    // Apply Merge sort to sort an array of Strings.
    // public static void MergeSort(String arr[], int si, int ei) {
    // if (si >= ei) {
    // return;
    // }

    // int mid = si + (ei - si) / 2;
    // MergeSort(arr, si, mid);
    // MergeSort(arr, mid + 1, ei);

    // Merge(arr, si, mid, ei);
    // }

    // public static void Merge(String arr[], int si, int mid, int ei) {
    // String temp[] = new String[ei - si + 1];

    // int i = si; // left pointer
    // int j = mid + 1; // right pointer
    // int k = 0; // temp tracker

    // while (i <= mid && j <= ei) {
    // if (arr[i].compareTo(arr[j]) < 0) {
    // temp[k++] = arr[i++];
    // } else {
    // temp[k++] = arr[j++];
    // }
    // }

    // while (i <= mid) {
    // temp[k++] = arr[i++];
    // }

    // while (j <= ei) {
    // temp[k++] = arr[j++];
    // }

    // for (i = si, k = 0; k < temp.length; i++, k++) {
    // arr[i] = temp[k];
    // }
    // }

    // Given an array nums of size n, return the majority element.

    public static int CountElement(int arr[], int element, int si, int ei) { // returns the count of the element
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] == element) {
                count++;
            }
        }

        return count;
    }

    public static int divideArray(int arr[], int si, int ei) {
        if (si == ei) {
            return arr[si];
        }

        int mid = si + (ei - si) / 2;

        int left = divideArray(arr, si, mid);
        int right = divideArray(arr, mid + 1, ei);

        if (left == right) {  // if two elements are equal then just return the element 
            return left;
        }

        // if the elements are different then gets their counts return element with maximum count
        // calculating count for the elements
        int leftCount = CountElement(arr, left, si, ei);
        int rightCount = CountElement(arr, right, si, ei);

        if (leftCount > rightCount) {  // retrun the element whose count is more
            return left;
        } else {
            return right;
        }
    }

    // Question 3 : Given an array of integers. Find the Inversion Count in the
    // array. (HARD)
    // Inversion Count: For an array, inversion count indicates how far (or close)
    // the array is from
    // being sorted. If the array is already sorted then the inversion count is 0.
    // If an array is
    // sorted in the reverse order then the inversion count is the maximum.
    // Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i <
    // j.
    // Sample Input 1 : N = 5, arr[ ] = {2, 4, 1, 3, 5}
    // Sample Output 1 : 3, because it has 3 inversions - (2, 1), (4, 1), (4, 3).

    static int inversions = 0;

    public static void MergeSort(int arr[], int si, int ei) {

        // base case

        if (si >= ei) {
            return;
        }

        // recursion

        int mid = si + (ei - si) / 2;

        MergeSort(arr, si, mid);
        MergeSort(arr, mid + 1, ei);

        Merge(arr, si, ei, mid);
    }

    public static void Merge(int arr[], int si, int ei, int mid) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0; // to trace the temp array

        while (i <= mid && j <= ei) {
            if (arr[j] < arr[i]) {
                temp[k++] = arr[j++];
                inversions += (mid - i + 1);
            } else {
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        // String arr[] = { "sun", "earth", "mars", "mercury" };
        // MergeSort(arr, 0, arr.length - 1);
        // PrintArray(arr);

        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        int MajorityElement = divideArray(arr, 0, arr.length - 1);
        System.out.println("Majority Element of the array = " + MajorityElement);

        // int arr[] = {5, 5, 5};
        // MergeSort(arr, 0, arr.length - 1);
        // PrintArray(arr);
        // System.out.println("Inversions: " + inversions);
    }

}
