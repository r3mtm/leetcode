/*

TAGS={Backtracking, Math}

60. Permutation Sequence

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

*/
class Solution { 
    int count = 0, k;
    
    // Brute force - O(n!)
    
    public String getPermutation(int n, int k) {
        this.k = k;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            sb.append((char)(i + 48));
        }
        return permute(sb.toString(), 0, n - 1);
    }
    
    private String permute(String s, int f, int l) {
        if (f == l) {
            ++count;
            if (count == k) {
                return s;
            }
            return null;
        }
        
        for (int i = f; i <= l; ++i) {
            s = swap(s, f, i);
            String str;
            if ((str = permute(s, f + 1, l)) != null) return str;
        }
        return null;
    }
    
    private String swap(String s, int i, int j) {
        char[] tempArray = s.toCharArray();
        char temp = tempArray[i];
        tempArray[i] = tempArray[j];
        tempArray[j] = temp;
        return new String(tempArray);
    }
}

public class PermutationSequence_60 {
    public static void main(String[] args) {
        int n = 5;
        int k = 10;
        System.out.println(new Solution().getPermutation(n, k));
    }
}
