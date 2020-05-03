/*

TAGS={String}

383. Ransom Note

Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines;
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

*/

class Solution {

    // 2ms solution
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        if (ransomNote.length() == 0) return true;
        
        // Given, strings contain only lowercase characters
        int[] charsCount = new int[26];
        int count = 0;
        
        for (int i = 0; i < ransomNote.length(); ++i) {
            int currentCharVal = ransomNote.charAt(i) - 'a';
            ++charsCount[currentCharVal];
        }
        
        for (int i = 0; i < magazine.length(); ++i) {
            int currentCharVal = magazine.charAt(i) - 'a';
            if (charsCount[currentCharVal] > 0) {
                ++count;
                if (count == ransomNote.length()) {
                    return true;
                }
                charsCount[currentCharVal] = Math.max(0, charsCount[currentCharVal] - 1);
            }
        }
        
        return false;
    }

    /* 
    // 43ms solution
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); ++i) {
            char currentChar = magazine.charAt(i);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
        }
        
        for (int i = 0; i < ransomNote.length(); ++i) {
            char currentChar = ransomNote.charAt(i);
            if (charCountMap.containsKey(currentChar)) {
                int val = charCountMap.get(currentChar);
                if (val == 1) {
                    charCountMap.remove(currentChar);
                } else {
                    charCountMap.put(currentChar, val - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }    
    */
}

public class RansomNote_383 {
    public static void main (String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(new Solution().canConstruct(ransomNote, magazine));
    }
}