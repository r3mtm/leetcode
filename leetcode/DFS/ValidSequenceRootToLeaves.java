/*

TAGS={DFS, Tree}

Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree

Given a binary tree where each path going from the root to any leaf form a valid sequence,
check if a given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the
nodes along a path results in a sequence in the given binary tree.
 

Example 1:


Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true

Explanation: 

The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0


Example 2:


Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 

Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.



Example 3:


Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 

Constraints:

1 <= arr.length <= 5000
0 <= arr[i] <= 9
Each node's value is between [0 - 9].

Hint #1:
Depth-first search (DFS) with the parameters: current node in the binary tree and current position in the array of integers.

Hint #2:
When reaching at final position check if it is a leaf node.

*/



import java.util.Stack;

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

class Store {
    
    int pos;
    TreeNode node;
    
    public Store(int pos, TreeNode node) {
        this.pos = pos;
        this.node = node;
    }
}

class ValidSequenceRootToLeaves {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) {
            return false;
        }
        if (arr.length == 0) {
            return true;
        }
        
        Stack<Store> stack = new Stack<>();
        TreeNode node = root;
        int i = 0;
        
        while (i < arr.length) {
            if (node.val == arr[i]) {
                if (i == arr.length - 1) {
                    if (node.left == node.right) {
                        return true;
                    }
                } else {
                    if (node.left != null) {
                        if (node.left.val == arr[i + 1]) {
                            stack.push(new Store(i + 1, node.left));
                        }
                    }
                    if (node.right != null) {
                        if (node.right.val == arr[i + 1]) {
                            stack.push(new Store(i + 1, node.right));
                        }
                    }
                }
                
            } 
            if (stack.empty()) {
                return false;
            }
            Store temp = stack.pop();
            i = temp.pos;
            node = temp.node;
        }
        
        return false; 
    }
}