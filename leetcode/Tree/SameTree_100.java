/*

TAGS={Tree, Depth-first Search}

100. Same Tree

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true


Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false


Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false


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
class Solution {
    
    Stack<TreeNode> p_stack;
    Stack<TreeNode> q_stack;
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null) {
            if (q != null) return false;
            
            return true;
        } else if (q == null) return false;
        
        p_stack = new Stack<>();
        q_stack = new Stack<>();
        
        p_stack.add(p);
        q_stack.add(q);
        
        while (!p_stack.isEmpty() && !q_stack.isEmpty()) {
            TreeNode temp_p = p_stack.pop();
            TreeNode temp_q = q_stack.pop();
            if (temp_p.val != temp_q.val) return false;
            
            if (temp_p.left != null) {
                if (temp_q.left != null) {
                    p_stack.push(temp_p.left);
                    q_stack.push(temp_q.left);
                } else {
                    return false;
                }
            } else if (temp_q.left != null) {
                return false;
            }
            
            if (temp_p.right != null) {
                if (temp_q.right != null) {
                    p_stack.push(temp_p.right);
                    q_stack.push(temp_q.right);
                } else {
                    return false;
                }
            } else if (temp_q.right != null) {
                return false;
            }
            
        }
        
        if (p_stack.size() != q_stack.size()) return false;
        
        return true;
    }
}