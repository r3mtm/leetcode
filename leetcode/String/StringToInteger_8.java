/*

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign
followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace characters,
no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
    If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example 1:

Input: "42"
Output: 42

Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.

Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.

Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.

*/

class StringToInteger_8 {
    static int myAtoi(String str) {
        int strLen = str.length(), i, digit, number = 0, prevNum, reversed;
        boolean isNegative = false;

        //checking if string is empty.
        if (strLen < 1) {
            return 0;
        }
        
        //determines the occurance of first digit and
        //also if it is positive or negative.
        for (i = 0; i < strLen; ++i) {
            if (str.charAt(i) == ' ') {
                //do nothing
            } else if (str.charAt(i) == '+') {
                ++i;
                break;
            } else if (str.charAt(i) == '-') {
                ++i;
                isNegative = true;
                break;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                break;
            } else {
                return 0;
            }
        }
        
        //checking for digits from its first occurance.
        for ( ; i < strLen; ++i) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                break;
            }
            prevNum = number;
            digit = str.charAt(i) - 48;
            number = number * 10 + digit;
            reversed = (number - digit) / 10;
            if (reversed != prevNum || number < 0) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if (isNegative) {
            return number * -1;
        }
        return number;
    }

    public static void main (String[] args) {
        String str = "-2147483648";
        System.out.println(myAtoi(str));
    }
}