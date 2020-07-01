/*

TAGS={Binary Search, Math}

441. Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.


Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.


*/

class Solution {
    // O(log n) runtime
    public int arrangeCoins(int n) {
        int left = 0, right = n, mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            long count = ((long)mid * (mid + 1)) / 2; // n * (n + 1) / 2
            if (count == n) {
                return mid;
            } else if (count < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }

    /*
    // O(n) runtime
    public int arrangeCoins(int n) {
        int i = 1;
        int count = -1;
        while (n >= 0) {
            n -= i++;
            ++count;
        }
        return count;
    }
    */
}

public class ArrangingCoins_441 {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(new Solution().arrangeCoins(n));
    }
}