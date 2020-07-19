/*

TAGS={Math, String}

67. Add Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"


Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.

*/

class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int minLen = Math.min(lenA, lenB);
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (minLen > 0) {
            int ch1 = a.charAt(--lenA) - '0';
            int ch2 = b.charAt(--lenB) - '0';
            
            int sum = ch1 + ch2 + carry;
            if (sum == 2) {
                carry = 1;
                result.append('0');
            } else if (sum == 3) {
                carry = 1;
                result.append('1');
            } else {
                carry = 0;
                result.append(sum + "");
            }
            --minLen;
        }

        if (lenA == 0) {
            result = iterateRemaining(b, result, lenB, carry);
        } else {
            result = iterateRemaining(a, result, lenA, carry);
        }
        
        return result.toString();
    }

    private StringBuilder iterateRemaining (String str, StringBuilder result, int index, int carry) {
        while (--index > -1) {
            int num = str.charAt(index) - '0';
            int sum = carry + num;
            if (sum == 2) {
                carry = 1;
                result.append('0');
            } else {
                carry = 0;
                result.append(sum + "");
            }
        }

        if (carry == 1) result.append('1');

        return result.reverse();
    }
}

class AddBinary_67 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new Solution().addBinary(a, b));
    }
}