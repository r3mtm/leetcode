/*

TAGS={Bit Manipulation}

137. Single Number II

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3


Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

*/


class Solution {
    public int singleNumber(int[] nums) {
        int total = 0, count, mask;
        for (int i = 0; i < 31; ++i) {
            mask = 1 << i;
            count = 0;
            
            for (int num : nums) {
                if ((mask & num) > 0) ++count;
            }
            
            if (count % 3 != 0) total = total | mask;
        }
        
        count = 0;
        mask = 1 << 31;
        for (int num : nums) {
            if ((mask & num) < 0) ++count; 
        }
        
        return count % 3 == 0 ? total : (int)Math.pow(2, 31) + total + 1;
    }
}

public class SingleNumberII_137 {
    public static void main(String[] args) {
        int[] nums = {-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
        System.out.println(new Solution().singleNumber(nums));
    }
}