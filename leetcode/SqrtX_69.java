/*

69. Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

*/

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int f = 0, l = 46341;
        int mid = 0;
        int temp;
        while (f <= l) {
            mid = (f + l) / 2;
            temp = mid * mid;
            if (temp == x) {
                return mid;
            }
            if (temp > x) {
                l = mid - 1;
            } else {
                f = mid + 1;
            }
        }
        temp = mid * mid;

        //temp < 0 ; to check if there's an
        //integer overflow.
        if (temp > x || temp < 0) {
            return mid - 1;
        }
        return mid;
    }
}

public class SqrtX_69 {
    public static void main (String[] args) {
        int num = 2147483647;
        System.out.println(new Solution().mySqrt(num));
    }
}