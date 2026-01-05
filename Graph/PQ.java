package Graph;

public class PQ {
    // Longest Region in Boolean Matrix 
    //     We have a matrix where each cell contains either a ‘0’ or a ‘1’, and any cell containing a 1 is
    // called a filled cell. Two cells are said to be connected if they are adjacent to each other
    // horizontally, vertically, or diagonally. If one or more filled cells are also connected, they form a
    // region. find the size of the largest region.

    public static boolean isSafe(int newR , int newC , int[][] matrix) {
        if(newR < 0 || newC < 0 || newR >= matrix.length || newC >= matrix[0].length) {
            return false;
        }

        return true;
    }

    public static int dfs(int[][] matrix , int row , int col , boolean[][] visited , int[] dr , int[] dc) {
        visited[row][col] = true;
        int area = 1;

        for(int i = 0 ; i < 8 ; i++) {
            int newR = row + dr[i];
            int newC = col + dc[i];

            if(isSafe(newR, newC, matrix)) {
                if((matrix[newR][newC] == 1) && !visited[newR][newC]) {
                    area += dfs(matrix, newR, newC, visited, dr, dc);
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0 , 1 , 1 , 0},
            {0 , 1 , 1 , 0},
            {0 , 0 , 0 , 1}
        };

        int maxRegion = 0;

        int[] dr = {-1 , -1 , 0 , 1 , 1 , 1 , 0, -1};
        int[] dc = {0 , 1 , 1 , 1 ,0 ,-1 , -1 , -1};

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(!visited[i][j] && matrix[i][j] == 1) {
                    maxRegion = Math.max(maxRegion, dfs(matrix, i, j, visited, dr, dc));
                }   
            }
        }
        
        System.out.println("Max Area Region = " + maxRegion );
    }
}


// Leetcode Questions

// 127. Word Ladder (Hard)

// class Solution {

//     static class Info {
//         String word;
//         int dis;

//         public Info(String word, int dis) {
//             this.word = word;
//             this.dis = dis;
//         }
//     }

//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         HashMap<String, Boolean> visited = new HashMap<>();
//         HashSet<String> set = new HashSet<>();

//         for (int i = 0; i < wordList.size(); i++) {
//             set.add(wordList.get(i));
//         }

//         Queue<Info> q = new LinkedList<>();
//         q.add(new Info(beginWord, 1));
//         visited.put(beginWord, true);

//         while (!q.isEmpty()) {
//             Info currInfo = q.remove();

//             if (currInfo.word.equals(endWord)) {
//                 return currInfo.dis;
//             }

//             for (int i = 0; i < currInfo.word.length(); i++) {
//                 char currChar = currInfo.word.charAt(i);
//                 for (int j = 0; j < 26; j++) {
//                     char ch = (char) ('a' + j);
//                     if (ch != currChar) {
//                         String newWord = currInfo.word.substring(0, i) + ch + currInfo.word.substring(i + 1);
//                         if ((set.contains(newWord)) && !visited.containsKey(newWord)) {
//                             q.add(new Info(newWord, currInfo.dis + 1));
//                             visited.put(newWord, true);
//                         }
//                     }

//                 }
//             }
//         }

//         return 0;
//     }
// }

// 695. Max Area of Island

// class Solution {
//     public static int dfs(int[][] grid , boolean[][] visited, int currArea , int[] dr , int[] dc , int row , int col ) {
//         visited[row][col] = true;
//         int area = 1;

//         for(int i = 0 ; i < 4 ; i++) {
//             int newR = row + dr[i];
//             int newC = col + dc[i];

//             if(newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length) {
//                 continue;
//             }

//             if(!visited[newR][newC] && grid[newR][newC] == 1) {
//                 area += dfs(grid , visited , currArea + 1 , dr , dc , newR , newC);
//             }
//         }

//         return area;
//     }

//     public int maxAreaOfIsland(int[][] grid) {
//         int[] dr = {-1 , 1 , 0 , 0};  // Top, Down , Right , Left 
//         int[] dc = { 0 , 0 , 1 , -1 };
//         int maxArea = 0;

//         boolean[][] visited = new boolean[grid.length][grid[0].length];

//         for(int i = 0 ; i < grid.length ; i++) {
//             for(int j = 0 ; j < grid[0].length ; j++) {
//                 if(!visited[i][j] && grid[i][j] == 1) {
//                     maxArea = Math.max(dfs(grid , visited , 1 , dr , dc , i , j) , maxArea);
//                 }
//             }
//         }

//         return maxArea;
//     }
// }

// 797. All Paths From Source to Target

// class Solution {
//     public static void dfs(List<List<Integer>> ans , List<Integer> temp , int[][] graph , int curr) {
//         if(curr == (graph.length - 1)) {
//             ans.add(new ArrayList<>(temp));
//             return;
//         }

//         for(int i = 0 ; i < graph[curr].length ; i++) {
//             temp.add(graph[curr][i]);
//             dfs(ans , temp , graph , graph[curr][i]);
//             temp.remove(temp.size() - 1);
//         }
//     }

//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         temp.add(0);
//         dfs(ans , temp , graph , 0);
    
//         return ans;
//     }
// }


// 994. Rotting Oranges

// class Solution {
//     static class Info {
//         int row;
//         int col;
//         int time;

//         public Info(int row, int col, int time) {
//             this.row = row;
//             this.col = col;
//             this.time = time;
//         }
//     }

//     public int orangesRotting(int[][] grid) {
//         int[] dr = { -1, 1, 0, 0 }; // Top , Bottom, Left , Right  // Row Changes
//         int[] dc = { 0, 0, -1, 1 }; // Coloumn Changes
//         int maxTime = 0;
//         Queue<Info> q = new LinkedList<>();

//         // Add initiall all the rotten oranges in the queue
//         int fresh = 0;
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 2) {
//                     q.add(new Info(i, j, 0));
//                 } else if (grid[i][j] == 1) {
//                     fresh++;
//                 }
//             }
//         }

//         while (!q.isEmpty()) {
//             Info currRotten = q.remove();

//             for (int i = 0; i < 4; i++) {
//                 int nxRow = currRotten.row + dr[i];
//                 int nxCol = currRotten.col + dc[i];

//                 if (nxRow < 0 || nxRow >= grid.length || nxCol < 0 || nxCol >= grid[0].length)  {
//                     continue;
//                 }

//                 if (grid[nxRow][nxCol] == 1) {
//                     grid[nxRow][nxCol] = 2;
//                     fresh--;
//                     q.add(new Info(nxRow, nxCol, currRotten.time + 1));
//                 }
//             }
//             maxTime = Math.max(currRotten.time, maxTime);
//         }

//         if (fresh == 0) {
//             return maxTime;
//         } else {
//             return -1;
//         }
//     }
// }