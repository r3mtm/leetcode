/*

TAGS={Hash Table}

49. Group Anagrams

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

*/

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<HashMap<Character, Integer>,List<String>> map = new HashMap<HashMap<Character, Integer>,List<String> >();
        for (String str : strs) {
            HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
            for (int i = 0; i < str.length(); ++i) {
                tempMap.put(str.charAt(i), tempMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            if (map.containsKey(tempMap)) {
                map.get(tempMap).add(str);
            } else {
                List<String> tempList = new ArrayList<String>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }
        List<List<String>> groupedList = new ArrayList<List<String>>();
        for (Map.Entry<HashMap<Character, Integer>, List<String>> entries : map.entrySet()) {
            groupedList.add(entries.getValue());
        }
        return groupedList;
    }
}

class GroupAnagrams_49 {
    public static void main (String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedList = new Solution().groupAnagrams(strs);
    }
}