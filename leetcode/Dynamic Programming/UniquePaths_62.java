/*

TAGS={Dynamic Programming, Array}

62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right


Example 2:

Input: m = 7, n = 3
Output: 28
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.

*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[n][m];
        
        for (int i = mat[0].length - 1; i >= 0; --i) {
            mat[mat.length - 1][i] = 1;
        }
        
        for (int i = mat.length - 1; i >= 0; --i) {
            mat[i][mat[0].length - 1] = 1;
        }
        
        for (int i = mat.length - 2; i >= 0; --i) {
            for (int j = mat[i].length - 2; j >= 0; --j) {
                mat[i][j] = mat[i + 1][j] + mat[i][j + 1];
            }
        }
        
        return mat[0][0];
    }
}

public class UniquePaths_62 {
    public static void main(String[] args) {
        int m = 7;
        int n = 3;

        System.out.println(new Solution().uniquePaths(m, n));
    }
}