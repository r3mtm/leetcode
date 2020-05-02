/*

TAGS={Hash Table}

771. Jewels and Stones

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

Hint:
For each stone, check if it is a jewel.

*/

import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String J, String S) {
        
        if (J.length() == 0 || S.length() == 0) return 0;
        
        HashSet<Character> jewelSet = new HashSet<>();
        int jewelCount = 0;
        
        for (int i = 0; i < J.length(); ++i) {
            jewelSet.add(J.charAt(i));
        }
        
        for (int i = 0; i < S.length(); ++i) {
            if (jewelSet.contains(S.charAt(i))) {
                ++jewelCount;
            }
        }
        
        return jewelCount;
    }
}

class JewelsandStones_771 {
    public static void main (String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(new Solution().numJewelsInStones(J, S));
    }
}