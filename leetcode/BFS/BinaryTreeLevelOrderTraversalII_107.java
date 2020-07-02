/*

TAGS={Breadth-first Search, Tree}

107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

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
    
    List<List<Integer>> list;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        list = new LinkedList<List<Integer>>(); 
        
        if (root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(new ArrayList<>());
        list.get(0).add(root.val);
        
        while (queue.size() > 0) {
            List<Integer> tempList = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            while (queue.size() > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    tempList.add(node.left.val);
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    tempList.add(node.right.val);
                    newQueue.add(node.right);
                }
            }
            list.add(0, tempList); // O(1) time.
            queue = newQueue;
        }
        list.remove(0);
        return list;
    }
}