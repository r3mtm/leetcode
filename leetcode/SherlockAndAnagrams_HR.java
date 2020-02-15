/*

Problem link : https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

*/

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Test {
    public static void main (String[] agrs) {
        String str = "abcd";
        Solution anagram = new Solution();
        System.out.println(anagram.sherlockAndAnagrams(str));
    }
}

class SherlockAndAnagrams_HR {

    boolean checkIfAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        Integer val;
    
        for (int i = 0; i < s1.length(); ++i) {
    
            val = count.get(s1.charAt(i));
            if (val == null) {
                count.put(s1.charAt(i), 1);
            } else {
                count.put(s1.charAt(i), val + 1);
            }
            val = count.get(s2.charAt(i));
            if (val == null) {
                count.put(s2.charAt(i), -1);
            } else {
                count.put(s2.charAt(i), val - 1);
            }
        }
    
        Iterator<Map.Entry<Character, Integer>> itr = count.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Character, Integer> temp = itr.next();
            if (temp.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    //static int MAX_CHARS = 256;
    /*boolean checkIfAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] count = new int[MAX_CHARS];
        Arrays.fill(count, 0);

        for (int i = 0; i < s1.length(); ++i) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < MAX_CHARS; ++i) {
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }*/

    int sherlockAndAnagrams(String s) {
        int count = 0;
        int len = s.length();
        ArrayList<String> anags = new ArrayList<String>();
        for (int i = 0; i < len; ++i) {
            anags.add(String.valueOf(s.charAt(i)));
            for (int j = i + 1; j < len; ++j) {
                anags.add(s.substring(i, j + 1));
            }
        }
        int size = anags.size();
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if (checkIfAnagram(anags.get(i), anags.get(j))) {
                    ++count;
                }
            }
        }
        return count;
    }
}
