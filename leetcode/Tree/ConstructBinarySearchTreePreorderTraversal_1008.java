/*

TAGS={Tree}

1008. Construct Binary Search Tree from Preorder Traversal

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and
any descendant of node.right has a value > node.val.
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)



Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.

*/


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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        root.left = root.right = null;
        for (int i = 1; i < preorder.length; ++i) {
            insert(root, preorder[i]);
        }
        return root;
    }
    
    public void insert(TreeNode node, int value) {
        TreeNode tempNode = node;
        TreeNode prevNode = node;
        
        while (tempNode != null) {
            prevNode = tempNode;
            if (value < tempNode.val) {
                tempNode = tempNode.left;
            } else {
                tempNode = tempNode.right;
            }
        }
        
        TreeNode newNode = new TreeNode(value);
        newNode.left = newNode.right = null;
        if (value < prevNode.val) {
            prevNode.left = newNode;
        } else {
            prevNode.right = newNode;
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConstructBinarySearchTreePreorderTraversal_1008 {
    public static void main (String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = new Solution().bstFromPreorder(preorder);
    }
}