/*

===Leftmost Column with at Least a One===


(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1.
For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples.
You will not have access the binary matrix directly.

Example 1:

Input: mat = [[0,0],[1,1]]
Output: 0


Example 2:

Input: mat = [[0,0],[0,1]]
Output: 1


Example 3:

Input: mat = [[0,0],[0,0]]
Output: -1


Example 4:

Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
 

Constraints:

1 <= mat.length, mat[i].length <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in a non-decreasing way.

Hints:

1. (Binary Search) For each row do a binary search to find the leftmost one on that row and update the answer.
2. (Optimal Approach) Imagine there is a pointer p(x, y) starting from top right corner. p can only move left or down.
    If the value at p is 0, move down. If the value at p is 1, move left.
    Try to figure out the correctness and time complexity of this algorithm.

*/

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    /*
    // 0ms solution
    // Time - O(row * log (col))
    // Space - O(1)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int lastCol = col + 1;
        for (int i = 0; i < row; ++i) {
            int left = 0, right = col - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (binaryMatrix.get(i, mid) == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left < col) {
                if (left < lastCol) {
                    lastCol = left;
                }
            }
        }
        if (lastCol == col + 1) {
            return -1;
        }         
        return lastCol;
    }
    */

    /*
    //0ms solution
    // Here we do binary search on every row, but the right boundary
    // will be set to the last found column on the previous row, since
    // we need only the leftmost column containing one, if any.

    // Worst case time complexity : O(row * log (col))
    // Space - O(1)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int lastPos = col;
        for (int i = 0; i < row; ++i) {
            int left = 0, right = lastPos - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (binaryMatrix.get(i, mid) == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left < lastPos) {
                if (left < lastPos) {
                    lastPos = left;
                }
            }
        }
        if (lastPos == col) {
            return -1;
        }         
        return lastPos;
    }
    */
 
    // 0ms solution
    // Time - O(max(row, col))
    // Space - O(1)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int r = 0, c = col - 1;
        int lastPos = col;
        while (r < row && c >= 0) {
            if (binaryMatrix.get(r, c) == 0) {
                ++r;
            } else {
                lastPos = c;
                --c;
            }
        }
        if (lastPos < col) {
            return lastPos;
        }
        return -1;
    }
}
