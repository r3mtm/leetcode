/*

TAGS={Array, Backtracking}

79. Word Search


Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3


*/
class Solution {
    
    String word;
    
    public boolean exist(char[][] board, String word) {
        this.word = word;
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] visited = new int[board.length][board[0].length];
                    if (dfs(board, visited, i, j, 0)) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int[][] visited, int i, int j, int index) {
        visited[i][j] = 1;
        
        if (index == word.length() - 1) {
            return true;
        }
        
        if (i - 1 >= 0 && visited[i - 1][j] != 1 && board[i - 1][j] == word.charAt(index + 1)) {
            if (dfs(board, visited, i - 1, j, index + 1)) return true;
        }
        
        if (i + 1 < board.length && visited[i + 1][j] != 1 && board[i + 1][j] == word.charAt(index + 1)) {
            if (dfs(board, visited, i + 1, j, index + 1)) return true;
        }
        
        if (j - 1 >= 0 && visited[i][j - 1] != 1 && board[i][j - 1] == word.charAt(index + 1)) {
            if (dfs(board, visited, i, j - 1, index + 1)) return true;
        }
        
        if (j + 1 < board[0].length && visited[i][j + 1] != 1 && board[i][j + 1] == word.charAt(index + 1)) {
            if (dfs(board, visited, i, j + 1, index + 1)) return true;
        }
        
        // reverting back to unvisited, if not found
        visited[i][j] = 0;
        
        return false;
        
    }
}

class WordSearch_79 {
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','E','S'},
            {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";

        System.out.println(new Solution().exist(board, word));
    }
}