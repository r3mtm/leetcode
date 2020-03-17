/*

TAGS={String, Two-pointer}

344. Reverse String


Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

*/

class Solution {
    public void reverseString(char[] s) {
        int f = 0;
        int l = s.length - 1;
        char temp;
        while (f < l) {
            temp = s[f];
            s[f] = s[l];
            s[l] = temp;
            l--;
            f++;
        }
    }
}

public class ReverseString_344 {
    public static void main (String[] args) {
        char[] s = {"h","e","l","l","o"};
        Solution sol = new Solution();
        sol.reverseString(s);
        for (int i = 0; i < s.length; ++i) {
            System.out.print(s[i] + " ");
        }
    }
}