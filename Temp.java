public class Temp {
    public static void PrintBoard(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "   ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static boolean KnightTour(int board[][] , int row , int col  ,int count) {
        // base case
        if (row < 0 || col < 0 || row > 7 || col > 7) {
            return false;
        }


        board[row][col] = count;
        if (count == 64) {
            PrintBoard(board);
            return true;
        }
        
        // Knight Moves
        int rowMoves[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int colMoves[] = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0 ; i < 8 ;i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];

            if (newRow >= 0 && newCol >= 0 && newRow < 8 && newCol < 8) {
                if (board[newRow][newCol] == 0) {
                    if(KnightTour(board, newRow, newCol, count + 1)) {
                        return true;
                    }
                }
            }
        }

        board[row][col] = 0;
        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        int board[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        KnightTour(board, 0, 0, 1);
    }
}
