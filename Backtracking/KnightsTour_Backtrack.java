package Backtracking;

public class KnightsTour_Backtrack {

    // static int count = 0;

    public static void PrintBoard(int board[][]) {
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0 ; j < board.length; j++) {
                System.out.print(board[i][j]+ "    ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void KnightsMoves(int board[][] , int row , int col , int step) {
        // base case

        if (row > 7 || col > 7) {
            return;
        } else if (row < 0 || col < 0) {
            return;
        } 
        
        board[row][col] = step;
        
        if (step == 64) {
            PrintBoard(board);
            // count++;
            // board[row][col] = 0;
            return;
        }

        // recursion
        int rowMoves[] = {-2, -2, -1, -1,  1,  1,  2,  2};
        int colMoves[] = {-1,  1, -2,  2, -2,  2, -1,  1};

        for (int i = 0 ; i < 8 ;i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];

            if(newRow >= 0 && newCol >= 0 && newRow < 8 && newCol < 8) {
                if(board[newRow][newCol] == 0) {
                    KnightsMoves(board, newRow, newCol , step+ 1);
                }
            }
        }

        board[row][col] = 0;
    }

    // Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.If it cannot reach the target position return -1.

    // Note:
    // The initial and the target position co-Zordinates of Knight have been given accoring to 1-base indexing.


    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N , boolean visited[][]) {
        // base Case
        int row = KnightPos[0];
        int col = KnightPos[1];

        if (row == TargetPos[0] && col == TargetPos[1]) {
            return 0;
        }

        if (row < 0 || col < 0 || row >= N || col >= N ) {
            return Integer.MAX_VALUE;
        }
        // Recursion
        if (visited[row][col]) {
            return Integer.MAX_VALUE;
        }

        visited[row][col] = true;
        int rowMoves[] = {-2, -2, -1, -1,  1,  1,  2,  2};
        int colMoves[] = {-1,  1, -2,  2, -2,  2, -1,  1};

        int minSteps = Integer.MAX_VALUE;

        for (int i = 0 ; i < 8 ; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];

            int newKnightPos[] = {newRow , newCol};
            int steps = minStepToReachTarget(newKnightPos, TargetPos, N , visited);

            if (steps != Integer.MAX_VALUE) {
                minSteps = Math.min(minSteps, steps + 1);
            }
        }

        // visited[row][col] = false;

        return minSteps;
    }
    public static void main(String[] args) {
        // int n = 8;
        // int board[][] = new int[n][n];

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         board[i][j] = 0;
        //     }
        // }

        // KnightsMoves(board , 0 , 0 , 1);
        // System.out.println("All possible solutions: " + count);

        int KnightPos[] = {4 , 5};
        int TargetPos[] = {1 , 1};
        int n = 6;

        boolean Visited[][] = new boolean[n][n];

        System.out.println("Minimum Steps: " + minStepToReachTarget(KnightPos , TargetPos , n , Visited));
    }
}
