// Leetcode Solution


// Most Optimized (TC - O(n)  and SC - O(1))
// class Solution {  
//     public int trap(int[] height) {
//         int n = height.length;
//         int leftMax = height[0];
//         int rightMax = height[n - 1];
//         int i = 0;
//         int j = n - 1;
//         int maxArea = 0;

//         while (i <= j) {
//             if (leftMax < rightMax) {
//                 leftMax = Math.max(leftMax , height[i]);
//                 maxArea += leftMax - height[i];
//                 i++;
//             } else {
//                 rightMax = Math.max(rightMax , height[j]);
//                 maxArea += rightMax - height[j];
//                 j--;
//             }
//         }

//         return maxArea;
//     }
// }

// TC - O(n)  SC = O(n)
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


// using Stack 
// Using Stack TC - O(n) and SC - O(n)
// class Solution {
//     public int trap(int[] height) {
//         Stack<Integer> s = new Stack<>();
//         int n = height.length;
//         int MaxTrapedWater = 0;

//         for (int i = 0 ;  i < n ; i++) {
//             while (!s.isEmpty() && height[s.peek()] < height[i]) {
//                 int pop_height = s.pop();

//                 if (s.isEmpty()) {
//                     break;
//                 }

//                 int distance = i - s.peek() - 1;
//                 int minHeight = Math.min(height[i] , height[s.peek()]) - height[pop_height];
//                 MaxTrapedWater += minHeight * distance;
//             }

//             s.push(i);
//         }

//         return MaxTrapedWater;
//     }
// }