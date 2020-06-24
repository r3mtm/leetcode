/*

TAGS={Dynamic Programming, Tree}

96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        
        int[] sum = new int[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                sum[i] = sum[i] + (sum[j] * sum[i - j - 1]);
            }
        }
        
        return sum[n];
    }
}

/*

e.g. n = 5,

When,

root = 1, left subtree = 0, right subtree = 4
root = 2, left subtree = 1, right subtree = 3
root = 3, left subtree = 2, right subtree = 2
root = 4, left subtree = 4, right subtree = 1
root = 5, left subtree = 5, right subtree = 0


Sum up all the cases and answer


f(0), where n = 0 => 1
f(1), where n = 1 => 1

f(n) = f(0) * f(n - 1) + f(1) * f(n - 2) + f(2) * f(n - 3) + .... + f(n - 1) * f(0)


*/


public class UniqueBinarySearchTrees_96 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().numTrees(n));
    }
}