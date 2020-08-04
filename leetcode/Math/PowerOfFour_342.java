/*

TAGS={Bit Manipulation, Math}

342. Power of Four


Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true


Example 2:

Input: 5
Output: false

Follow up: Could you solve it without loops/recursion?


*/

class Solution {
    public boolean isPowerOfFour(int num) {
        
        double log = Math.log(num)/Math.log(4);
        int res = (int)log;
        
        if(log == (double)res) return true;
        
        return false;
    }
}

public class PowerOfFour_342 {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(new Solution().isPowerOfFour(num));
    }
}