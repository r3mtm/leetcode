import java.util.HashMap;

public class BoyerMoore {
    public static void main (String[] args) {
        int position;
        char[] txt = "ababababbabbbabbabaab".toCharArray();
        char[] pattern = "aa".toCharArray();

        Searching obj = new Searching(pattern);
        if ((position = obj.search(txt, pattern)) != -1) {
            System.out.printf("Pattern found at location %d\n", position);
        } else {
            System.out.println("Pattern not found");
        }
    }
}

class Searching {
    HashMap<Character, Integer> occrBd;
    
    //Array to store the index of the suffix of a largest border
    //at a given position 'i'. If it doesn't exists for a particular
    //index, then the index[i] stores the value "pattern.length".
    int[] suffixPos;

    //Array which stores the shift distance if a mismatch occurs
    //at a location 'i'.
    int[] shiftDist;

    //length of the pattern minus 1
    int patLenMinusOne;

    public Searching() {}

    public Searching(char[] pattern) {
        occrBd = new HashMap<Character, Integer>();
        suffixPos = new int[pattern.length + 1];
        shiftDist = new int[pattern.length + 1];
        patLenMinusOne = pattern.length - 1;

        /*Preprocessing the pattern*/

        //Bad character heuristics
        prepBadHeu(pattern);

        //Good character heuristics with same substring exists
        //to the left of the matched substring, with different character
        //behind it.
        prepGudHeuC1(pattern);

        //Good character heuristics with part of the substring exits
        //to the left of the matched substring.
        prepGudHeuC2(pattern);
    }

    public int search(char[] txt, char[] pat) {   
        int i = 0, j, bound;
        j = patLenMinusOne;
        bound = i + j;
        while (bound < txt.length) {
            while(bound >= i && txt[bound] == pat[j]) {
                --j;
                bound = i + j;
            }
            if (j == -1) {
                return i;
            }
            i += findNextPos(txt[bound], j);
            j = patLenMinusOne;
            bound = i + j;
        }
        
        return -1;
    }

    public int findNextPos(char x, int j) {
        return Math.max(j - getCloseIndexOfChar(x), shiftDist[j + 1]);
    }
    
    //This function calculates the bad character heuristics for
    //an index 'i'. Uses a Hashtable to store the last occuring
    //index of a particular character.
    public void prepBadHeu(char[] pat) {
        for (int i = 0; i <pat.length; ++i) {
            occrBd.put(pat[i], i);
        }
    }

    //Returns the last occuring index of a particular
    //character from the Hashtable.
    public Integer getCloseIndexOfChar(char x) {
        Integer index = occrBd.get(x);
        if (index == null) {
            return -1;
        }
        return index;
    }

    //This function calculates the the shift values
    //for a particular index. Shift value is found,
    //by checking if the same matched substring is available
    //in the pattern, when matched from right to left.
    public void prepGudHeuC1(char[] pat) {
        int secondLast = pat.length - 2;
        int last = pat.length - 1;
        int i = secondLast, j = last;
        
        suffixPos[j] = pat.length;
        suffixPos[pat.length] = pat.length + 1;

        //First calculates the suffix position of every
        //character substring in the pattern. If the 
        //chars. at positions 'i' and 'j' matched, then
        //it means the character substring starting at
        //position 'i' has a suffix at position 'j'. 
        //So "suffixPos[i] = j". If it is not matched,
        //check if the last character matches with i'th
        //character, if yes, set suffixPos[i] as index of 
        //last character, else set it to pattern length.

        while (i > -1) {
            if (pat[i] != pat[j]) {
                if (pat[last] == pat[i]) {
                    suffixPos[i] = last;
                    j = secondLast;
                } else {
                    suffixPos[i] = suffixPos[last];
                    j = last;
                }
                --i;
            } else {
                suffixPos[i] = j;
                --i;
                --j;
            }
        }

        //After obtaining the suffixes of each substring
        //at a given position 'i', the array "shitftDist"
        //is used to store the shifting distance, which is needed
        //whenever a mismatch occurs at a position 'j'. If a mismatch
        //occurs, then shifting distance will able at position 'j+1'
        //since it has matched upto the substring position 'j', when
        //matched from right to left. This function only calculates 
        //the shifting distance of substring which has a border.
        //For remaning ones, zero is set.

        i = 1;
        while (i < pat.length) {
            j = suffixPos[i];
            while (j < pat.length) {
                if (pat[i - 1] != pat[j - 1]) {
                    shiftDist[j] = j - i;
                }
                j = suffixPos[j];
            }
            ++i;
        }
    }

    //Case 2, where there is border for the given substring
    //In this case the shifting distance will be stored in the
    //"suffixPos" array. For the last element the shifting position will
    //depends on the factor, how many consequtive positions are occupied
    //by the same last character. e.g. "abbabbabbb". In this case, it records
    //the last zero and subtract the suffixPos value of pattern-length + 1
    //and the position 'i'.
    public void prepGudHeuC2(char[] pat) {
        int j = suffixPos[0];
        int lastZero = 0;
        int len = suffixPos.length - 1;
        for (int i = 0; i < len; ++i) {
            if (shiftDist[i] == 0) {
                shiftDist[i] = j;
                lastZero = i;
            }
            if (i == j) {
                j = suffixPos[j];
            }
        }
        shiftDist[len] = suffixPos[pat.length] - suffixPos[lastZero];
    }
}