/*

TAGS={Two pointer, Stack}

844. Backspace String Compare


Given two strings S and T, return if they are equal when both are typed into
empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?


*/

class Solution {
    //Follow up - Time : O(S + T) 0ms
    //Space - O(1)
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int S_bsCount = 0;
        int T_bsCount = 0;
        boolean foundBs;
        
        while (i > -1 && j > -1) {
            
            foundBs = false;
            
            if (S.charAt(i) == '#') {
                ++S_bsCount;
                --i;
                foundBs = true;
            }
            if (T.charAt(j) == '#') {
                ++T_bsCount;
                --j;
                foundBs = true;
            }
            
            if (foundBs) {
                continue;
            } else {
                if (S_bsCount > 0) {
                    --i;
                    --S_bsCount;
                    if (T_bsCount > 0) {
                        --j;
                        --T_bsCount;
                    }
                    continue;
                }
                if (T_bsCount > 0) {
                    --T_bsCount;
                    --j;
                    continue;
                }
                
                if (S.charAt(i) == T.charAt(j)){
                    --i;
                    --j;
                } else {
                    return false;
                }
            }
        }
        if (i > -1 && j < 0) {
            if (S.charAt(i) != '#' && S_bsCount == 0) {
                return false;
            }
        }
        
        if (j > -1 && i < 0) {
            if (T.charAt(j) != '#' && T_bsCount == 0) {
                return false;
            }
        }
        
        return true;
    }

    /*
    //Time : O(S+T)
    //Space : O(S+T)
    //2ms solution
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack_S = new Stack<Character>();
        Stack<Character> stack_T = new Stack<Character>();
        int len = S.length(), i = 0;
        while (i < len) {
            if (S.charAt(i) == '#') {
                if (!stack_S.empty()) {
                    stack_S.pop();
                }
            } else {
                stack_S.push(S.charAt(i));
            }
            ++i;
        }
        i = 0;
        len = T.length();
        while(i < len) {
            if (T.charAt(i) == '#') {
                if (!stack_T.empty()) {
                    stack_T.pop();
                }
            } else {
                stack_T.push(T.charAt(i));
            }
            ++i;
        }
        if (String.valueOf(stack_S).equals(String.valueOf(stack_T))) {
            return true;
        } else {
            return false;
        }
    }
    */

}

class BackspaceStringCompare_844 {
    public static void main (String[] args) {
        String S = "du###vu##v#fbtu";
        String T = "du###vu##v#e#fbn#tu";
        System.out.println(new Solution().backspaceCompare(S, T));
    }
} 