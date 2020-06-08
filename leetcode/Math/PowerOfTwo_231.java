/*

TAGS={Math, Bit Manipulation}

231. Power of Two

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1

Example 2:

Input: 16
Output: true
Explanation: 24 = 16

Example 3:

Input: 218
Output: false


*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if (n <= 0) return false;
        /*
        // 2ms solution
        int res = (int) (Math.log(n)/Math.log(2));
        if ((int)Math.pow(2, res) == n) return true;
        return false;
        */
        
        // 1ms solution
        return (n & (-n)) == n;
    }
}

public class PowerOfTwo_231 {
    public static void main (String[] args) {
        int n = 16;
        System.out.println(new Solution().isPowerOfTwo(n));
    }
}