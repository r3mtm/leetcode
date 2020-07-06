/*

TAGS={Array}

66. Plus One

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.


Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

*/

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; --i) {
            digits[i] = digits[i] + 1;
            if (digits[i] != 10) return digits;
            digits[i] = digits[i] == 10 ? 0 : digits[i];
            
        }
        int[] newResult = new int[digits.length + 1];
        newResult[0] = 1;
        for (int i = 1; i < newResult.length; ++i) {
            newResult[i] = digits[i - 1];
        }
        return newResult;
    }
}

public class PlusOne_66 {
    public static void main(String[] args) {
        int[] digits ={9,9,9};
        int[] result = new Solution().plusOne(digits);
        for(int digit: result) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }
}