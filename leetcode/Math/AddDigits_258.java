/*

258. Add Digits

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.


Follow up:
Could you do it without any loop/recursion in O(1) runtime?


*/

class Solution {
    public int addDigits(int num) {
        int result = num;
        while (num > 0) {
            num = result;
            result = 0;
            while (num > 0) {
                int a = num % 10;
                num = num / 10;
                result += a;
            }
            num = result / 10;
        }
        return result;
    }
    /*
        public int addDigits(int num) {
            if (num == 0) return 0;
            if (num % 9 == 0) return 9;
            return num % 9;
        }
    */
}

public class AddDigits_258 {
    public static void main(String[] args) {
        int num = 3423;
        System.out.println(new Solution().addDigits(num));
    }
}