/*

TAGS={Array, Dynamic Programming}

64. Minimum Path Sum


Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

class Solution {
    //O(M * N) time
    //O(1) space
    //2ms solution
    public int minPathSum(int[][] grid) {
        int i = grid.length - 1;
        for (int j = grid[i].length - 2; j > -1; --j) {
            grid[i][j] = grid[i][j] + grid[i][j + 1];
        }
        
        for (i = grid.length - 2; i > -1; --i) {
            for (int j = grid[0].length - 1; j > -1; --j) {
                boolean goRight = false;
                int min;
                if (j + 1 < grid[0].length) {
                    goRight = true;
                }
                if (goRight) {
                    min = Math.min(grid[i][j] + grid[i][j + 1], grid[i][j] + grid[i + 1][j]);
                } else {
                    min = grid[i][j] + grid[i + 1][j];
                }
                grid[i][j] = min;        
            }
        }
        return grid[0][0];
    }

    /*
        //O(M * N) time
        //O(1) space
        //3ms solution
        public int minPathSum(int[][] grid) {
            for (int i = grid.length - 1; i > -1; --i) {
                for (int j = grid[i].length - 1; j > -1; --j) {
                    int min = Integer.MAX_VALUE;
                    if (j + 1 < grid[i].length) {
                        min = grid[i][j] + grid[i][j + 1];
                    }
                    if (i + 1 < grid.length) {
                        min = Math.min(grid[i][j] + grid[i + 1][j], min);
                    }
                    
                    if (min != Integer.MAX_VALUE) {
                        grid[i][j] = min;
                    }
                }
            }
            return grid[0][0];
        }
    */

}

public class MinimumPathSum_64 {
    public static void main (String[] args) {
        int[][] grid = {
                            {1,3,1},
                            {1,5,1},
                            {4,2,1}
                       };
        System.out.println(new Solution().minPathSum(grid));
    }
}
