/*

TAGS={DFS}

200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1


Example 2:

Input:
11000
11000
00100
00011

Output: 3

*/


/*

//O(N) time
//O(N) space
//2ms solution
class Solution {
    
    int[][] visited;
    public int numIslands(char[][] grid) {
        if (grid.length < 1) {
            return 0;
        }
        visited = new int[grid.length][grid[0].length];
        int count = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    check(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }
    
    public void check(char[][] grid, int row, int col) {
        //marked as visited
        visited[row][col] = 1;
        
        //Up
        if (row > 0 && grid[row][col] == '1' && visited[row - 1][col] != 1) {
            check(grid, row - 1, col);
        }
        
        //Right
        if (col < grid[row].length - 1 && grid[row][col] == '1' && visited[row][col + 1] != 1) {
            check(grid, row, col + 1);
        }
        
        //Down
        if (row < grid.length - 1 && grid[row][col] == '1' && visited[row + 1][col] != 1) {
            check(grid, row + 1, col);
        }
        
        //Left
        if (col > 0 && grid[row][col] == '1' && visited[row][col - 1] != 1) {
            check(grid, row, col - 1);
        }
    }
}

*/

//O(N) - time
//O(1) - space
//1ms solution
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length < 1) {
            return 0;
        }
        int count = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    check(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }
    
    public void check(char[][] grid, int row, int col) {
        //marked as visited
        grid[row][col] = 'x';
        
        //Up
        if (row > 0 && grid[row - 1][col] == '1') {
            check(grid, row - 1, col);
        }
        
        //Right
        if (col < grid[row].length - 1 && grid[row][col + 1] == '1') {
            check(grid, row, col + 1);
        }
        
        //Down
        if (row < grid.length - 1 && grid[row + 1][col] == '1') {
            check(grid, row + 1, col);
        }
        
        //Left
        if (col > 0 && grid[row][col - 1] == '1') {
            check(grid, row, col - 1);
        }
    }
}

public class NumberOfIslands_200 {
    public static void main (String[] args) {
        char[][] grid = {
                            {'1','1','0','0','0'},
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'}
                        };
        System.out.println(new Solution().numIslands(grid));
    }
}
