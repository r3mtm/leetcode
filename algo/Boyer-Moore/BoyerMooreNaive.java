/*
    Boyer-Moore string searching using Bad Character Heuristic,
    with no performance gain.
*/

public class BoyerMooreNaive {
    public static void main (String[] agrs) {
        //char[] A = "cabaacbabxaaaabbbcabcab".toCharArray();
        char[] A = "WHICH-FINALLY-HALTS.--AT-THAT-POINT".toCharArray();
        char[] B = "AT-THAT.".toCharArray();
        System.out.println(new Searching().searching(A, B));
    }
}

class Searching {
    boolean searching(char[] A, char[] B) {
        boolean exists = false;
        int i = 0;
        int j, lenB = B.length - 1, bound;
        j = lenB;
        bound = i + j;
        while (bound < A.length) {
            //System.out.println("i = " + i + " (i + j) = " + (i + j));
            while (bound >= i) {
                //System.out.println("A[i + j] = " + A[i + j] + " B[j] = " + B[j]);
                if (A[bound] == B[j]) {
                    --j;
                    bound = i + j;
                } else {
                    j = findNextPos(A[bound], B, j - 1);
                    //System.out.println("j = " + j);
                    break;
                }
            }
            if (j == -1) {
                return true;
            }

            if (j == -2) {
                i = bound + 1;
            } else {
                i += lenB - j;
            }
            j = lenB;
            bound = i + j;
        }
        return exists;
    }

    int findNextPos(char x, char[] B, int pos) {
        while (pos > -1) {
            //System.out.println("B[pos] = " + B[pos] + " x = " + x);
            if (B[pos] == x) {
                return pos;
            }
            --pos;
        }
        return -2;
    }
}