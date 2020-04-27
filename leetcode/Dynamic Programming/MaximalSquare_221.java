/*

TAGS={Dynamic Programming}

221. Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/


class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }
        int[][] mat = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    mat[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1'){
                    mat[i][j] = Math.min(Math.min(mat[i][j - 1],mat[i - 1][j]), mat[i - 1][j - 1]) + 1;
                }
                max = Math.max(mat[i][j], max);
            }
        }
        return max * max;
    }
}

public class MaximalSquare_221 {
    public static void main (String[] args) {
        char[][] matrix = {
                            {'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}
                          };
        System.out.println(new Solution().maximalSquare(matrix));
    }
}