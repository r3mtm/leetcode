/*

TAGS={Bit Manipulation}

201. Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647,
return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

*/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int sum = 0;
        int match = 1073741824;
        while (match > 0) {
            int mAnd = m & match;
            int nAnd = n & match;
            if (mAnd == match && nAnd == match) {
                sum += match;
            } else if (mAnd != nAnd) {
                break;
            }
            match = match >> 1;
        }
        return sum;
    }
}

public class BitwiseANDofNumbersRange_201 {
    public static void main (String[] args) {
        int m = 8, n = 10;
        System.out.println(new Solution().rangeBitwiseAnd(m, n));
    }
}