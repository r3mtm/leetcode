/*

TAGS={Dynamic Programming}

1143. Longest Common Subsequence


Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none)
deleted without changing the relative order of the remaining characters.
(eg, "ace" is a subsequence of "abcde" while "aec" is not).
A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.
 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.

*/

class Solution {
    // Time - O(text1.len * text2.len)
    // Space - O(text1.len * text2.len)
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] mat = new int[text1.length()][text2.length()];
        for (int i = 0; i < text2.length(); ++i) {
            if (text2.charAt(i) == text1.charAt(0)) {
                while (i < text2.length()) {
                    mat[0][i] = 1;
                    ++i;
                }
                break;
            } else {
                mat[0][i] = 0;
            }
        }
        
        for (int i = 0; i < text1.length(); ++i) {
            if (text1.charAt(i) == text2.charAt(0)) {
                while (i < text1.length()) {
                    mat[i][0] = 1;
                    ++i;
                }
                break;
            } else {
                mat[i][0] = 0;
            }
        }
        
        for (int i = 1; i < text1.length(); ++i) {
            for (int j = 1; j < text2.length(); ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        return mat[text1.length() - 1][text2.length() - 1];
    }
}

public class LongestCommonSubsequence_1143 {
    public static void main (String[] args) {
        String text1 = "bbcrc";
        String text2 = "brcbc";
        System.out.println(new Solution().longestCommonSubsequence(text1, text2));
    }
}