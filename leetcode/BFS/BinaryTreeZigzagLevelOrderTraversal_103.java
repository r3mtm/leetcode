/*

TAGS={Stack, Tree, Breadth-first Search}

103. Binary Tree Zigzag Level Order Traversal


Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).



For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if (root == null) return new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean isBackward = false;
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            Queue<TreeNode> tempQueue = new LinkedList<>();
            List<Integer> tempList = new LinkedList<>();
            
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (isBackward) {
                    tempList.add(0, node.val);
                } else {
                    tempList.add(node.val);
                }
                
                if (node.left != null) {
                    tempQueue.add(node.left);
                }
                if (node.right != null) {
                    tempQueue.add(node.right);
                }
            }
            
            queue = tempQueue;
            result.add(tempList);
            isBackward = !isBackward;
        }
        
        return result;
    }
}