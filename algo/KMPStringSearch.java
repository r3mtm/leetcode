/*
    Substring search algorithm using Knuth-Morris-Pratt Algorithm.
    Runtime complexity : O(n + m)   ; n = length of the text.
                                    ; m = length of the pattern.
                                    ; O(m) is for pattern preprocessing.
    Space complexity : O(m)
*/

public class KMPStringSearch {
    public static void main (String[] args) {
        char[] text = "abcxabcdabxabcdabcdabcy".toCharArray();
        char[] pattern = "abcdabcy".toCharArray();

        PreProcess obj = new PreProcess(pattern);
        obj.search(text, pattern);
    }
}

class PreProcess {

    int[] procArr;

    public PreProcess(char[] pattern) {
        
        //The idea is to find if there is a perfect suffix and perfect prefix
        //for each string at length 'i'. If there is get the max. of the border
        //(a.k.a. perfect suffix and perfect prefix).

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

    public void search(char[] text, char[] pattern) {
        int i = 0, j = 0;
        while (i < text.length) {
            if (text[i] == pattern[j]) {
                ++i;
                ++j;
                if (j == pattern.length) {
                    System.out.println("Pattern found at location " + (i - pattern.length));
                    break;
                }
            } else if (j == 0){
                ++i;
            } else {
                j = procArr[j - 1];
            }
        }

        if (j != pattern.length) {
            System.out.println("Pattern not found");
        }
    }

    public void debugDisp() {
        for (int i = 0; i < procArr.length; ++i) {
            System.out.print(procArr[i]);
        }
    }
}