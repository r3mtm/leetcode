/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }
    
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lH = getHeight(node.left);
        int rH = getHeight(node.right);
        int height = Math.max(lH, rH) + 1;
        if (lH + rH > diameter) {
            diameter = lH + rH;
        }
        return height;
    }
}


//add main function
