/*



230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1


Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3


Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?

 

Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class KthSmallestElementBST_230 {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        count = 0;
        return find(node, k);
    }
    
    public int find(TreeNode node, int k) {
        if (node.left != null) {
            int val = find(node.left, k);
            if (val != -1) return val;
        }
        if (++count == k) {
            return node.val;
        }
        if (node.right != null) {
            int val = find(node.right, k);
            if (val != -1) return val;
        }
        return -1;
    }
}