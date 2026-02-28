// Leetcode 198 
// House Robber

// class Solution {

//     // Dynamic Programming Tabulation Approch

//     public int rob(int[] nums) {
//         // Creating the DP Table
//         int dp[][] = new int[2][nums.length];

//         // Initialize
//         dp[0][0] = nums[0];
//         dp[1][0] = 0;

//         // meaning -> dp[0][i] -> Maximum Profit if we robbed the house 
//         // and dp[1][i] -> Maximum Profit if we not robbed the house

//         // Filling the table
//         for(int i = 1 ; i < nums.length ; i++) {
//             // Robbed the current House
//             dp[0][i] = nums[i] + dp[1][i - 1];  // If we robbed the current house then not able to robbed the previous house

//             // Do not Robb the current house
//             dp[1][i] = Math.max(dp[0][i - 1] , dp[1][i - 1]); // just put the maximum profit from the previous houses
//         }

//         return Math.max(dp[0][nums.length - 1] , dp[1][nums.length - 1]);
//     }
// }

// 213. House Robber II

// class Solution {
 
//     // This Question is similar as house robber part 1
//     // just change needed is we have robb 0 to n - 1 houses first 
//     // then again robb 1 to n houses 
//     // so that 1st and last house can not robbed at same time

//     public int rob_helper(int[] nums , int x , int y) {

//         // Creating the table
//         int dp[][] = new int[2][nums.length];

//         // Initializing the values
//         dp[0][x] = nums[x];
//         dp[1][x] = 0;

//         for(int i = x + 1 ; i <= y ; i++) {
//             dp[0][i] = nums[i] + dp[1][i - 1];  // Robb The current house
//             dp[1][i] = Math.max(dp[0][i - 1] , dp[1][i - 1]); // Do not Robb the current House
//         }

//         return Math.max(dp[0][y] , dp[1][y]);
//     }

//     public int rob(int[] nums) {
//         if(nums.length == 0) return 0;
//         if(nums.length == 1) return nums[0];
//         int n = nums.length;
//         return Math.max(rob_helper(nums , 0 , n - 2) , rob_helper(nums , 1 , n - 1));
//     }
// }


// Leetcode
// 63. Unique Paths II

// class Solution {

//     // Dynamic Programming Tabulation Approch

//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         if (m == 0 && n == 0) {
//             return 0;
//         }
//         if (obstacleGrid[0][0] == 1) {
//             return 0;
//         }

//         // Creating the Table
//         int dp[][] = new int[m][n];

//         // Initializing 
//         int initVal = 1;
//         for(int i = 0 ; i < m ; i++) {
//             if(obstacleGrid[i][0] == 1) {
//                 initVal = 0;
//             }
//             dp[i][0] = initVal;
//         }
//         initVal = 1;
//         for(int j = 0 ; j < n ; j++) {
//             if(obstacleGrid[0][j] == 1) {
//                 initVal = 0;
//             }
//             dp[0][j] = initVal;
//         }

//         for(int i = 1 ; i < m ; i++) {
//             for(int j = 1 ; j < n ; j++) {
//                 if(obstacleGrid[i][j] == 0) {
//                     dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                 } else {
//                     dp[i][j] = 0;
//                 }
//             }
//         }

//         return dp[m - 1][n - 1];
//     }
// }