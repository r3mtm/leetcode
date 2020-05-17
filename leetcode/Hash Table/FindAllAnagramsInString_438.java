/*

TAGS={Hash Table}

438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

class FindAllAnagramsInString_438 {

    //6 ms
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (s.length() < p.length()) return result;
        
        int[] charCount = new int[26];
        int[] charMap = new int[26];
        int pLen = p.length();
        
        for (int i = 0; i < pLen; ++i) {
            ++charCount[p.charAt(i) - 'a'];
            ++charMap[s.charAt(i) - 'a'];
        }
        
        if (Arrays.equals(charCount, charMap)) result.add(0);
        
        for (int i = pLen; i < s.length(); ++i) {
            --charMap[s.charAt(i - pLen) - 'a'];
            ++charMap[s.charAt(i) - 'a'];
            if (Arrays.equals(charCount, charMap)) result.add(i - pLen + 1);
        }
        
        return result;
    }


    /* 
    // 1321 ms
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (s.length() < p.length()) return result;
        
        int[] charCount = new int[26];
        int len_P = p.length();
        int len_S = s.length();
        
        for (int i = 0; i < len_P; ++i) {
            ++charCount[p.charAt(i) - 'a'];
        }
        boolean needToCheck;
        int val, temp;
        
        for (int i = 0; i < len_S; ++i) {
            int index = i;
            int limit = Math.min(i + len_P, len_S);
            int[] charMap = new int[26];
            needToCheck = true;
            
            while (index < limit) {
                
                val = charCount[s.charAt(index) - 'a'];
                if (val == 0) {
                    i = index;
                    needToCheck = false;
                    break;
                }
                
                ++charMap[s.charAt(index) - 'a'];
                ++index;
            }
            if (needToCheck) {
                if (Arrays.equals(charCount, charMap)) {
                    result.add(i);
                }
            }
        }        
        return result;
    } 
    */
}