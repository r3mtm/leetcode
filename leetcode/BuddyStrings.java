/*

859. Buddy Strings


Given two strings A and B of lowercase letters, return true if and only if we can swap two
letters in A so that the result equals B.
 

Example 1:

Input: A = "ab", B = "ba"
Output: true

Example 2:

Input: A = "ab", B = "ab"
Output: false

Example 3:

Input: A = "aa", B = "aa"
Output: true

Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:

Input: A = "", B = "aa"
Output: false

 

Note:

    0 <= A.length <= 20000
    0 <= B.length <= 20000
    A and B consist only of lowercase letters.

*/


class Solution {
    public boolean buddyStrings(String A, String B) {
        int len = A.length();
        int lastMiss = -1;
        if (len != B.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < len; ++i) {
            
            if (A.charAt(i) == B.charAt(i)) {
                ++count[A.charAt(i) - 97];
            } else {
                if (lastMiss == -2) {
                    return false;
                }
                if (lastMiss != -1) {
                    if (A.charAt(lastMiss) == B.charAt(i) && B.charAt(lastMiss) == A.charAt(i)) {
                        lastMiss = -2;
                    } else {
                        return false;
                    }
                } else {
                    lastMiss = i;
                }
            }
        }
        if (lastMiss == -1) {
            for (int i = 0; i < 26; ++i) {
                if (count[i] > 1) {
                    return true;
                }
            }
            return false;
        }else if (lastMiss != -2) {
            return false;
        }else {
            return true;
        }
    }
}

public class BuddyStrings {
    public static void main (String[] args) {
        System.out.println(new Solution().buddyStrings("aaabaaac", "aaacaaab"));
    }
}