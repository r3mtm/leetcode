/**
 * Program to generate all permutations of size `k` from a string `s`.
 * 0 < k <= length(s)
 */

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {
    public static void main(String[] args) {
        String s = "abc";
        int size = 2;
        System.out.println(new Solution().generate(s, size));
    }
}

class Solution {

    List<String> permutations;

    public Solution() {
        permutations = new ArrayList<>();
    }

    public List<String> generate(String s, int size) {
        generateAll(s, size, 0);
        return permutations;
    }

    public void generateAll(String s, int size, int index) {
        if (index == size) {
            permutations.add(s.substring(0, size));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            s = swap(s, i, index);
            generateAll(s, size, index + 1);
        }
    }

    public String swap(String s, int i, int k) {
        char[] str = s.toCharArray();
        char temp = str[i];
        str[i] = str[k];
        str[k] = temp;
        return new String(str);
    }
}