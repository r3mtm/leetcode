/*

TAGS={String}

520. Detect Capital


Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False


Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

*/

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        
        int capitalCount = 0;
        
        for (int i = 1; i < word.length(); ++i) {
            if (word.charAt(i) < 'a') ++capitalCount;
        }
        
        if (capitalCount == 0) return true;
        
        if (capitalCount == word.length() - 1) {
            if (word.charAt(0) < 'a') return true;
        }
        
        return false;
    }
}

public class DetectCapital_520 {
    public static void main(String[] args) {
        String word = "FlaG";
        System.out.println(new Solution().detectCapitalUse(word));
    }
}