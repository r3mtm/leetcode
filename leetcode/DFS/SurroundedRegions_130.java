/*

TAGS={DFS, BFS, Union Find}

130. Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/

class Solution {
    
    public void solve(char[][] board) {
        
        if (board.length == 0) return;
                
        // top most row
        for (int i = 0; i < board[0].length; ++i) {
            if (board[0][i] == 'O') {
                checkSurrounding(board, 0, i);
            }
        }
        
        // right most column
        for (int i = 0; i < board.length; ++i) {
            // last col = board[0].length
            if (board[i][board[0].length - 1] == 'O') {
                checkSurrounding(board, i, board[0].length - 1);
            }
        }
        
        // bottom row
        for (int i = 0; i < board[0].length; ++i) {
            if (board[board.length - 1][i] == 'O') {
                checkSurrounding(board, board.length - 1, i);
            }
        }
        
        // left most column
        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == 'O') {
                checkSurrounding(board, i, 0);
            }
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'C') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    private void checkSurrounding(char[][] board, int i, int j) {
        
        board[i][j] = 'C';
        
        // go top
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            checkSurrounding(board, i - 1, j);
        }
        
        // go right
        if (j + 1 < board[i].length && board[i][j + 1] == 'O') {
            checkSurrounding(board, i, j + 1);
        }
        
        // go down
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            checkSurrounding(board, i + 1, j);
        }
        
        // go left
        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            checkSurrounding(board, i, j - 1);
        }
        
    }
}

public class SurroundedRegions_130 {
    public static void main (String[] args) {
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };

        new Solution().solve(board);

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}