package Backtracking;

public class BacktrackingPQ {

    // Question 1 :
    // Rat in a Maze
    // You are given a starting position for a rat which is stuck in a maze at an
    // initial point (0, 0) (the
    // maze can be thought of as a 2-dimensional plane). The maze would be given in
    // the form of a
    // square matrix of order N * N where the cells with value 0 represent the
    // maze’s blocked
    // locations while value 1 is the open/available path that the rat can take to
    // reach its destination.
    // The rat's destination is at (N - 1, N - 1).
    // Your task is to find all the possible paths that the rat can take to reach
    // from source to
    // destination in the maze.
    // The possible directions that it can take to move in the maze are 'U'(up) i.e.
    // (x, y - 1) , 'D'(down)
    // i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).
    // (This problem is similar to Grid ways.)

    public static boolean isSafe(int maze[][] , int directions[]) {

    }

    public static boolean Maze(int maze[][] , int i , int j) {
        // base case
        int n = maze.length;
        if (i == n-1 && j == n - 1) {
            return true;
        } else if (i == n || j == n) {
            return false;
        } else if (i < 0 || j < 0) {
            return false;
        }

        // recursion

        int up = j - 1 , down = j + 1,  left = i - 1, right = i + 1;
        int directions[] = {up , down , left , right};
        int nextI , nextJ;

        for (int d = 0 ; d < 4 ; d++) {
            if(isSafe(maze, directions[d])) {
                if(directions[d] == up || directions[d] == down) {
                    maze[i][directions[d]] = 1;
                    if(Maze(maze, i, directions[d])) {
                        return true;
                    }
                    maze[i][directions[d]] = 0;
                } else {
                    maze[directions[d]][j] = 1;
                    if(Maze(maze, directions[d], j)) {
                        return true;
                    }
                    maze[directions[d]][j] = 0;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } 
            };
        
        Maze(maze , 0 , 0);
    }
}