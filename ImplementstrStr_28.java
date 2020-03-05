/*
class PreProcess {

    int[] procArr;
    char[] pattern;
    
    public PreProcess(char[] pattern) {
        this.pattern = pattern;
        int j = 0, i = 1;
        procArr = new int[pattern.length];
        procArr[0] = 0;

        while (i < pattern.length) {
            while (j > -1) {
                if (pattern[j] == pattern[i]) {
                    procArr[i] = j + 1;
                    ++i;
                    ++j;
                    break;
                }
                if (j == 0) {
                    procArr[i] = 0;
                    ++i;
                    break;
                }
                j = procArr[j - 1];
            }
        }
    }

    public int search(char[] text) {
        int i = 0, j = 0;
        while (i < text.length) {
            if (text[i] == pattern[j]) {
                ++i;
                ++j;
                if (j == pattern.length) {
                    return i - pattern.length;
                }
            } else if (j == 0){
                ++i;
            } else {
                j = procArr[j - 1];
            }
        }

        if (j != pattern.length) {
            return -1;
        }
        return -1;
    }
}

*** 2ms solution using KMP

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return new PreProcess(needle.toCharArray()).search(haystack.toCharArray());
    }
}
*/


// *** 0ms solution ***
class Solution {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        int len = haystack.length() - needleLen + 1;
        for (int i = 0; i < len; ++i) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}


public class ImplementstrStr_28 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
