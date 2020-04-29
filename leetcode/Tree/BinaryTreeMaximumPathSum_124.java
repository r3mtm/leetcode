/*

TAGS={Tree}

124. Binary Tree Maximum Path Sum


Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


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
class BinaryTreeMaximumPathSum_124 {

    int sum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int result = find(root);
        return Math.max(result, sum);
    }
    
    public int find(TreeNode node) {
        int left = 0;
        int right = 0;
        
        sum = Math.max(node.val, sum);
        if (node.left == node.right) {
            return node.val;
        }
        
        if (node.left != null) {
            left = find(node.left);
            sum = Math.max(sum, node.val + node.left.val);
        }
        if (node.right != null) {
            right = find(node.right);
            sum = Math.max(sum, node.val + node.right.val);
        }
        
        sum = Math.max(sum, left + right + node.val);
        
        int max = Math.max(left, right);
        if (max + node.val < node.val) {
            return node.val;
        }
        return max + node.val;
    }
}