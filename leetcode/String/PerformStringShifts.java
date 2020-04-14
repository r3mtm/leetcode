/*

TAGS={String}

Perform String Shifts - 30 day leetcoding challenge

You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift). 
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

 

Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation: 
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:  
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 

Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100

Hint #1:
Intuitively performing all shift operations is acceptable due to the constraints.

Hint #2:
You may notice that left shift cancels the right shift, so count the total left shift
times (may be negative if the final result is right shift), and perform it once.

*/

class Solution {
    public String stringShift(String s, int[][] shift) {
        char[] str = new char[s.length()];
        int left = 0, right = 0;
        for (int i = 0; i < shift.length; ++i) {
            if (shift[i][0] == 0) {
                left += shift[i][1];
            } else {
                right += shift[i][1];
            }
        }
        if (left == right) {
            return s;
        } else if (left > right) {
            int j = (left - right) % s.length();
            int i = 0, k = j;
            while (k < s.length()) {
                str[i++] = s.charAt(k++);
            }
            k = 0;
            while (k < j) {
                str[i++] = s.charAt(k++);
            }
        } else if (right > left) {
            int j = s.length() - (right - left) % s.length();
            int i = 0, k = j;
            while (k < s.length()) {
                str[i++] = s.charAt(k++);
            }
            k = 0;
            while (k < j) {
                str[i++] = s.charAt(k++);
            }
        }
        return new String(str);
    }
}

public class PerformStringShifts {
    public static void main (String[] agrs) {
        String s = "abcdefg";
        int[][] shift = {
                            {1,1},
                            {1,1},
                            {0,2},
                            {1,3}
                        };
        System.out.println(new Solution().stringShift(s, shift));
    }
}