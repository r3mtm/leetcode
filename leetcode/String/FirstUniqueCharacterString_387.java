/*

TAGS={Hash Table, String}

387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index.
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.


Note: You may assume the string contain only lowercase letters.

*/

class Solution {
    // Time - O(N)
    // Space - O(N) or O(1) since total space taken will 26.
    public int firstUniqChar(String s) {
        //Given only lowercase characters
        int[] letterCount = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++letterCount[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < s.length(); ++i) {
            if (letterCount[s.charAt(i) - 'a'] == 1) return i;
        }
        
        return -1;
    }
}

public class FirstUniqueCharacterString_387 {
    public static void main (String[] args) {
        String s = "loveleetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}