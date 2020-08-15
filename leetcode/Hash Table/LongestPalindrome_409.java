/*

TAGS={Hash Table}

409. Longest Palindrome



Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int tempCount = entry.getValue();
            if (tempCount % 2 == 0) count += tempCount;
            else count += (tempCount - 1);
        }
        
        if (count != s.length()) ++count;
        
        return count;
    }
}

public class LongestPalindrome_409 {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(new Solution().longestPalindrome(s));
    }
}