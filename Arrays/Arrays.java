package Arrays;
public class Arrays {

    // Linear Search 

    // public static int linearSearch(int arr[] , int key) {
    //     for(int i = 0; i < arr.length ; i++) {
    //         if(arr[i] == key) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // Largest Value
    // public static int getLargeAndSmall(int arr[]) {
    //     int largestNumber = Integer.MIN_VALUE;
    //     int smallestNubmer = Integer.MAX_VALUE;

    //     for(int i = 0 ;i < arr.length ; i++) {
    //         if(arr[i] > largestNumber) {
    //             largestNumber = arr[i];
    //         }
    //         if(arr[i] < smallestNubmer) {
    //             smallestNubmer = arr[i];
    //         }
    //     }

    //     System.out.println("Minimum Value of Array: " + smallestNubmer);
    //     return largestNumber;
    // }

    // Binary Search

    // public static int BinarySearch(int arr[] , int key) {
    //     int start = 0;
    //     int end = arr.length - 1;
    //     while (start <= end) {
    //         int mid = ( start + end ) / 2;
    //         if(arr[mid] == key) {
    //             return mid;
    //         } else if(arr[mid] < key) {
    //             start = mid + 1;
    //         } else {
    //             end = mid - 1;
    //         }
    //     }

    //     return -1;
    // }

    // Reverse an Array

    // public static void Reverse(int arr[]) {
    //     int start = 0 , end = arr.length - 1;
    //     while (start < end) {
    //         int temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;
            
    //         start ++;
    //         end --;
    //     }
    // }

    // Pairs in array

    // public static void pairArray(int arr[]) {
    //     int tp = 0;
    //     for (int i = 0 ; i < arr.length ;i++) {
    //         for (int j = i + 1 ; j <  arr.length ; j++) {
    //             System.out.print("("  + arr[i] + "," + arr[j] + ")" + " ");
    //             tp ++;
    //         }
    //         System.out.println();
    //     }
    //     System.out.println(tp);
    // }

    // Print Subarrays  //important

    // public static void PrintSubarray(int arr[]) {
    //     int ts = 0;
    //     int minSum = Integer.MAX_VALUE;
    //     int maxSum = Integer.MIN_VALUE;
    //     for(int i = 0; i < arr.length ;i++) {
    //         for(int j = i + 1; j <= arr.length ; j++) {
    //             int sum = 0;
    //             System.out.print("[ ");
    //             for(int k = i ; k < j; k++) {
    //                 sum += arr[k];
    //                 System.out.print(arr[k] + " ");
    //             }
    //             ts++;
    //             System.out.print("]" + " = " + sum);
    //             if(sum < minSum) {
    //                 minSum = sum;
    //             }
    //             if(sum > maxSum) {
    //                 maxSum = sum;
    //             }
    //             System.out.println();
    //         }
    //         System.out.println();
    //     }
    //     System.out.println(ts);
    //     System.out.println("Min Sum = " + minSum);
    //     System.out.println("Max Sum = " + maxSum);
    // }

    // public static void PrefixSubarraySum(int arr[]) {
    //     int prefixArray[] = new int[arr.length];
    //     int maxSum = Integer.MIN_VALUE;

    //     prefixArray[0] = arr[0];

    //     for(int i = 1 ; i < arr.length ; i++) {
    //         prefixArray[i] = prefixArray[i - 1] + arr[i];
    //     }
    //     for(int i = 0; i < arr.length ; i++ ) {
    //         for(int j = i ; j < arr.length ; j++) {
    //             int sum = 0;
    //             sum = i == 0? prefixArray[j] : prefixArray[j] - prefixArray[i - 1]; // important
    //             if(maxSum < sum) {
    //                 maxSum = sum;
    //             }
    //         }
    //     }

    //     System.out.println("Maximum subArray sum : " + maxSum);

    // }
    
    // Kadanes alogorithm  // important

    // public static void Kadanes(int arr[]) {
    //     int cs = arr[0];
    //     int ms = Integer.MIN_VALUE;

    //     for(int i = 1; i < arr.length; i++) {
    //         cs = Math.max(arr[i], cs + arr[i]);

    //         ms = Math.max(ms, cs);
    //     }
    //     System.out.println("Maximum Sum is: " + ms);
    // }

    // Trapping rain water
    // public static void TrapRainWater(int arr[]) {
    //     int leftMaxB[] = new int[arr.length];
    //     int rightMaxB[] = new int[arr.length];
    //     int maxLeft = Integer.MIN_VALUE;
    //     int maxRight = Integer.MIN_VALUE;
    //     for(int i = 0 ; i < arr.length ; i++) {
    //         maxLeft = Math.max(maxLeft , arr[i]);
    //         leftMaxB[i] = maxLeft;
    //     }
    //     for(int i = arr.length - 1 ; i >= 0 ; i--) {
    //         maxRight = Math.max(maxRight, arr[i]);
    //         rightMaxB[i] = maxRight;
    //     }
    //     int totalRainWater = 0;

    //     for(int i = 0 ; i < arr.length ; i++) {
    //         int WaterLevel = Math.min(leftMaxB[i] , rightMaxB[i]);
    //         int trapWater = ( WaterLevel - arr[i] ) * 1;
    //         totalRainWater += trapWater;
    //     }
    //     System.out.println(totalRainWater);
    // }

    
    // Best time to Buy and Sell Stock

    // public static void Stock(int arr[]) {
    //     int bestProfit = 0;
    //     int buyPrice = arr[0];
    //     for(int i = 1 ; i < arr.length ; i++) {
    //         int profit = arr[i] - buyPrice;
    //         bestProfit = Math.max(profit, bestProfit);
    //         buyPrice = Math.min(buyPrice, arr[i]);
    //     }
    //     System.out.println(bestProfit);
    // }

    // Contains duplicate

    // public static boolean CDuplicate(int arr[]) {
    //     for(int i = 0 ; i < arr.length ; i++) {
    //         for (int j = i + 1 ; j < arr.length ; j++) {
    //             if(arr[i] == arr[j]){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // search in rotated array  //important

    // public static int Search(int arr[] , int target) {
    //     int pivot = pivotIndex(arr);

    //     if(arr[pivot] <= target && arr[pivot] >= arr[arr.length - 1]) {
    //         return Search(arr, target , pivot , arr.length);
    //     } else {
    //         return Search(arr, target , 0 , pivot);
    //     }
    // }

    // public static int Search(int arr[] , int target , int left  ,int right) {
    //     int l = left;
    //     int r = right;
        
    //         // int arr[] = {4,5,6,7,0,1,2};

    //     while (l < r) {
    //         int mid = (l + r) / 2;
    //         if(arr[mid] == target) {
    //             return mid;
    //         } else if(arr[mid] < target) {
    //             l = mid + 1;
    //         } else {
    //             r = mid - 1;
    //         }
    //     }

    //     return - 1;
    // }

     // Pivot in rotated shorted array

    // public static int pivotIndex(int arr[]) {
    //     int left = 0;
    //     int right = arr.length - 1;

    //     while (left <= right) {
    //         int mid = (left + right) / 2;

    //         if(mid > 0 && arr[mid - 1] > arr[mid]) {
    //             return mid;
    //         } else if(arr[mid] >= arr[left] && arr[right] <= arr[mid]) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }

    //     return left;
    // }


    public static void main(String[] args) {
        // int number[] = {2 , 8 , 12 , 16 , 18 , 19 , 25};
        // int number[] = {1 , -3 , 2};
        // int key = 25;

        // int index = linearSearch(number, key);

        // if(index == -1) {
        //     System.out.println("Not found");
        // } else {
        //     System.out.println("Index of the key is: " + index);
        // }

        // int largestNumber = getLargeAndSmall(number);
        // System.out.println("Largest Value in array: " + largestNumber);

        // int key = 12;
        // int index = BinarySearch(number, key);
        // if(index == -1) {
        //     System.out.println("Not Found");
        // } else {
        //     System.out.println("Index of the key is : " + index);
        // }

        // Reverse(number);
        // for(int i = 0 ; i < number.length ; i++) {
        //     System.out.print(number[i] + " ");
        // }

        // pairArray(number);

        // PrintSubarray(number);

        // PrefixSubarraySum(number);

        // Kadanes(number);

        // int Height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        // TrapRainWater(Height);

        // int prices[] = {7,1,5,3,6,4};
        // Stock(prices);

        // int arr[] = {1,2,3,4};
        // System.out.println(CDuplicate(arr));

        // int arr[] = {4,5,6,7,0,1,2};
        // System.out.println(Search(arr, 6));
    }
}
