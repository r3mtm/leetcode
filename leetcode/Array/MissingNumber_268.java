/*

TAGS={Array, Bit Manipulation}

268. Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity.
Could you implement it using only constant extra space complexity?

*/

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, i;
        for (i = 0; i < nums.length; ++i) {
            sum = sum ^ nums[i];
            sum = sum ^ i;
        }
        sum = sum ^ i;
        return sum;
    }
}

public class MissingNumber_268 {
    public static void main (String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(new Solution().missingNumber(nums));
    }
}