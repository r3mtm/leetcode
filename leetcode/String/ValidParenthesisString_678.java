/*

TAGS={String}

678. Valid Parenthesis String

Given a string containing only three types of characters: '(', ')' and '*', write a function to check
whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True


Note:
The string size will be in the range [1, 100].

*/

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> pStack = new Stack<Integer>();
        Stack<Integer> aStack = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                pStack.push(i);
            } else if (s.charAt(i) == '*') {
                aStack.push(i);
            } else {
                if (pStack.empty()) {
                    if (aStack.empty()) {
                        return false;
                    } else {
                        aStack.pop();
                    }
                } else {
                    pStack.pop();
                }
            }
        }
        if (!pStack.empty()) {
            while (!pStack.empty() && !aStack.empty()) {
                if(pStack.pop() > aStack.pop()) {
                    return false;
                }
            }
        }
        
        if (!pStack.empty()) {
            return false;
        }
        return true;
    }
}

public class ValidParenthesisString_678 {
    public static void main (String[] args) {
        String s = "(((******))";
        System.out.println(new Solution().checkValidString(s));
    }
}