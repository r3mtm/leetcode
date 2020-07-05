/*

TAGS={Bit Manipulation}

461. Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

*/

class Solution {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int mask = 1, count = 0;
        for (int i = 0; i < 31; ++i) {
            if ((mask & result) > 0) {
                ++count;
            }
            mask = mask << 1;
        }
        
        return count;
    }
}

public class HammingDistance_461 {
    public static void main(String[] args) {
        int x = 345345, y = 345354;
        System.out.println(new Solution().hammingDistance(x, y));
    }
}