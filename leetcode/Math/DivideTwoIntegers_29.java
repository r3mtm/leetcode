/*

TAGS = {Math}

29. Divide Two Integers


Given two integers dividend and divisor, divide two integers without using multiplication,
division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part.
For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.


Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.


Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

*/

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean negative = false;
        
        if ((dividend < 0 && divisor > 0) || (dividend >0 && divisor < 0)) {
            negative = true;
        }
        int quotient = 0;
        
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
        
        while (divid >= divis) {
            int shiftCount = 0;
            long temp = 0;
            while(divid >= temp) {
                temp = divis << shiftCount++;
            }
            
            shiftCount -= 2;
            
            divid -= divis << shiftCount;
            quotient += 1 << shiftCount;
        }
        if (negative) {
            return -quotient;
        }
        return quotient;
    }
}

/*

Rounding error for some test cases

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // if (dividend == Integer.MAX_VALUE && divisor == 1) {
        //     return Intger.MAX_VALUE;
        // }
        
        if (dividend == 0) {
            return 0;
        }
        boolean negative = false;
        
        if ((dividend < 0 && divisor > 0) || (dividend >0 && divisor < 0)) {
            negative = true;
        }
        int quotient = 0;
        
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
        
        //long quo = (long) Math.pow(10, Math.log10(divid) - Math.log10(divis));
        
        double val = Math.pow(10, Math.log10(divid) - Math.log10(divis));
        
        // if (0 != (long)val){
        //     System.out.println(Math.round(val));
        // }
        if (0 != (int) val) {
            quotient = (int) Math.round(val);   
        }
        if (negative) {
            //if (-quo == Integer.MAX_VALUE + 1) {
                
                return -quotient;
            //}
        }
        //quotient = (int) quo;
        return quotient;
    }
}

*/

public class DivideTwoIntegers_29 {
    public static void main (String args) {
        int dividend = -2147483648;
        int divisor = 2;
        System.out.println(new Solution().divide(dividend, divisor));
    }
}