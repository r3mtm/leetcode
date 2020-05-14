/*

402. Remove K Digits

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.


Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.


Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


*/

class Solution {
    public String removeKdigits(String num, int k) {
        int digitLen = num.length();
        if (digitLen == k) return "0";
        
        char[] digits = new char[digitLen];
        int pos = -1;
        int initK = k;
        
        for (int i = 0; i < digitLen; ++i) {
            char digit = num.charAt(i);
            
            while (pos > -1 && digits[pos] > digit && k > 0) {
                --pos;
                --k;
            }
            digits[++pos] = digit;
        }
        
        while (k > 0) {
            --k;
            --pos;
        }
        
        int i = 0;
        while (i < digitLen && digits[i] == '0') {++i;}
        
        if (i == digitLen - initK) return "0";
        
        return new String (digits, i, pos - i + 1);
    }
}

public class RemoveKDigits_402 {
    public static void main (String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(new Solution().removeKdigits(num, k));
    }
}