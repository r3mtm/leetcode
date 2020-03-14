/*

125. Valid Palindrome

Given a string, determine if it is a palindrome,
considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

*/

class Solution {
    // ** 2 ms solution **
    public boolean isPalindrome(String s) {
        int f = 0, l = s.length() - 1;
        while (f < l) {
            int ch1 = s.charAt(f);
            int ch2 = s.charAt(l);
            
            if (!Character.isLetterOrDigit(ch1)) {
                ++f;
                continue;
            }
            
            if (!Character.isLetterOrDigit(ch2)) {
                --l;
                continue;
            }
            
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            ++f;
            --l;
        }
        return true;
    }
    
    /*
    // **3 ms solution **
    
    public boolean isPalindrome(String s) {
        int len = s.length();
        char[] str = new char[len];
        int l = 0;
        for (int i = 0; i < len; ++i) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str[l++] = Character.toLowerCase(s.charAt(i));
            }
        }
        int f = 0;
        --l;
        while(f < l) {
            if (str[f] != str[l]) {
                return false;
            }
            ++f;
            --l;
        }
        return true;
    }
    */
}

public class ValidPalindrome_125 {
    public static void main (String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().isPalindrome(s));
    }
}