/*

633. Sum of Square Numbers


Given a non-negative integer c, your task is to decide whether
there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5

 

Example 2:

Input: 3
Output: False


*/


class Solution {
    public boolean judgeSquareSum(int c) {
        int j = (int)Math.sqrt(c);
        int i = 0, sum;
        
        if (j*j > c) {
            --j;
        }
        while (i <= j) {
            sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                ++i;
            } else {
                ++i;
                --j;
            }
        }
        return false;
    }
}

public class SumOfSquareNumbers_633 {
    public static void main (String[] args) {
        int c = 25;
        System.out.println(new Solution().judgeSquareSum(c));
    }
}