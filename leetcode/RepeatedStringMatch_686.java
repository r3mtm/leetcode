/*

686. Repeated String Match


Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

*/

/*
**** 1ms solution ****
*/
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        int index = B.indexOf(A);

        //Case where length string A is greater than the
        //length of the string B. 
        //e.g. A = aabaa, B = aab; A = aa, B = a;
        //The idea is to append the string A atmost 2 times
        //and check if that appended string contains the
        //string B. If yes return count, else return -1.
        if (index < 0) {
            StringBuilder copiedString = new StringBuilder();
            for (int i = 0; i < 2; ++i){
                if (copiedString.indexOf(B) < 0){
                    continue;
                }
                return i + 1;
            }
            return -1;
        }
        int lenA = A.length();

        //It is necessary to check the index at which the string A
        //first appeared in string B. If the starting of the Strings
        //A and B doesn't match, it means that either the occurrence
        //of string A in string B is preceeded by sequence of string A
        //without the first character or it is an invalid one.
        //e.g. A = abcdcd, B = cdabcdcd. Here "abcd" in string B
        //starts at position 2 (starting from zero).

        //To check this we need to obtain the **lastIndex** of the substring
        //before the first occurrence of string A in B and check if that
        //matches its length matches as following.
        //e.g. Length of "cd" = 2, and lenA = 6. So 6 - 4 = 2; (lastIndex of "cd" = 4)

        if (index != 0) {
            if (A.lastIndexOf(B.substring(0, index)) != (lenA - B.substring(0, index).length())) {
                return -1;
            }
            ++count;
        }
        int lastIndex = B.lastIndexOf(A);
        
        //Setting the next index to next possible position
        int i = index + lenA, j = lastIndex;
        
        //After checking the index position of last occurrence
        //of string A in string B. We need to verify that no other
        //substring exists in in between first and last occurrences.
        //e.g. A = abcd, B = cdabcdacbdabcdabcdabcdabcd
        while (i <= j) {
            if (A.indexOf(B.substring(i, i + lenA)) < 0) {
                return -1;
            }
            i += lenA;
        }

        //calculating the no. of occurrences in between.
        count += (lastIndex - index + 1) / lenA;
        
        index = lastIndex + lenA;
        int lenB = B.length();

        //Like we checked the substrings before the first occurrence
        //in string B, we need to check the same with substrings after the
        //last occurrence. The key idea is that, if the substring occurring
        //after last occurrence in string B, that substring's index should be
        //zero in string A. Else it is invalid or not possible.
        //e.g. A = abcd, B = abcdcd; Here the substring "cd" at the end of 
        //string A is invalid. So return -1;
        //e.g. A = abcd, B = abcdab; Valid, since "ab" index = 0;
        if (index < lenB) {
            index = A.indexOf(B.substring(index, lenB));
            if (index != 0) {
                return -1;
            }
            ++count;
        } else if (lenA == 1){
            //If the length of the string A is 1, the subtract one from the total count and return
            return count - 1;
        }
        
        return count;
    }
}


public class RepeatedStringMatch_686 {
    public static void main (String[] args) {
        System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));
    }
}


/*

**** 4 ms solution ****

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int repeat = (int)Math.ceil((float) B.length() / A.length());
        StringBuilder multiplied = new StringBuilder();
        for (int i = 0; i < repeat; ++i) {
            multiplied.append(A);
        }
        char[] pat = B.toCharArray();
        Searching obj = new Searching(pat);
        if (obj.search(multiplied.toString().toCharArray(), pat) != -1) {
            return repeat;
        }
        else {
            multiplied.append(A);
            if (obj.search(multiplied.toString().toCharArray(), pat) != -1) {
                return repeat + 1;
            }
        }
        return -1;
    }
}

class Searching {

    int[] procArr;

    public Searching(char[] pattern) {
        //KMP Searching algo.
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

    public int search(char[] text, char[] pattern) {
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
*/