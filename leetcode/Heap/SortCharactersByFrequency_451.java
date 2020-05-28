/*

TAGS={Heap}

451. Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.


Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        // PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
        //     @Override
        //     public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
        //         return entry2.getValue() - entry1.getValue();
        //     }
        // });
        
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> 
                                            e2.getValue() - e1.getValue());
        
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            queue.add(entry);
        }
        
        StringBuilder sb = new StringBuilder(s.length());
        int i, limit;
        char charc;
        
        while (queue.size() > 0) {
            Map.Entry<Character, Integer> entry = queue.poll();
            i = 0;
            limit = entry.getValue();
            charc = entry.getKey();
            while (i++ < limit) {
                sb.append(charc);
            }
        }
        
        return sb.toString();
    }
}

public class SortCharactersByFrequency_451 {
    public static void main (String[] args) {
        String s = "tree";
        System.out.println(new Solution().frequencySort(s));
    }
}