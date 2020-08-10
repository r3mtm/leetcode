/*

TAGS={Breadth-first search}

994. Rotting Oranges


In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4


Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.


Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Index {
        int i,j;
        
        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<Index> queue = new LinkedList<>();
        int fresh = 0, count = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) ++fresh;
                else if (grid[i][j] == 2) {
                    queue.add(new Index(i, j));
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k< size; ++k) {
                Index index = queue.poll();
                int i = index.i, j = index.j;
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    queue.add(new Index(i - 1, j));
                    --fresh;
                    grid[i-1][j] = 2;
                } 
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    queue.add(new Index(i + 1, j));
                    --fresh;
                    grid[i+1][j] = 2;
                } 
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    queue.add(new Index(i, j - 1));
                    --fresh;
                    grid[i][j - 1] = 2;
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    queue.add(new Index(i, j + 1));
                    --fresh;
                    grid[i][j + 1] = 2;
                }
            }
            ++count;
        }
        if (fresh != 0) return -1;

        return count == 0 ? 0 : count - 1;
    }
}


public class RottingOranges_994 {
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        System.out.println(new Solution().orangesRotting(grid));
    }
}