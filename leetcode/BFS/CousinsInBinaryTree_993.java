/*

TAGS={Breadth First Search}

993. Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
 

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true


Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.


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
class CousinsInBinaryTree_993 {
    // BFS
    // 0 ms
    // O(N)
    class Store {
        TreeNode node;
        int depth;
        
        public Store(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<Store>queue = new LinkedList<>();
        int depth = -1;
        
        queue.add(new Store(root, 0));
        
        while (queue.size() > 0) {
            Store temp = queue.removeFirst();
            TreeNode node = temp.node;
            int curDepth = temp.depth;
            
            if (node.left != null) {
                if (node.left.val == x || node.left.val == y) {
                    depth = curDepth;
                    break;
                } else {
                    queue.add(new Store(node.left, curDepth + 1));
                }
            }
            if (node.right != null) {
                if (node.right.val == x || node.right.val == y) {
                    depth = curDepth;
                    break;
                } else {
                    queue.add(new Store(node.right, curDepth + 1));
                }
            }
        }
        
        while (queue.size() > 0) {
            Store temp = queue.removeFirst();
            TreeNode node = temp.node;
            int curDepth = temp.depth;
            if (node.left != null) {
                if (node.left.val == x || node.left.val == y) {
                    if (curDepth == depth) {
                        return true;
                    }
                    return false;
                }
            }
            if (node.right != null) {
                if (node.right.val == x || node.right.val == y) {
                    if (curDepth == depth) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}


/* 
class CousinsInBinaryTree_993 {
    // Traverse tree twice
    // O(N)
    // 0 ms
    class Store{
        TreeNode node;
        int depth;
        
        public Store (TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    Stack<Store> stack;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        stack = new Stack<Store>();
        getNode(root, x, 0);
        getNode(root, y, 0);
        if (stack.size() < 2) {
            return false;
        }
        Store nodeY = stack.pop();
        Store nodeX = stack.pop();
        
        if (nodeY.node == nodeX.node) {
            return false;
        } else if (nodeY.depth == nodeX.depth){
            return true;
        }
        return false;
    }
    
    public void getNode(TreeNode node, int x, int level) {
        if (node.left != null) {
            if (node.left.val == x) {
                stack.push(new Store(node, level));
                return;
            } else {
                getNode(node.left, x, level + 1);
            }
        }
        if (node.right != null) {
            if (node.right.val == x) {
                stack.push(new Store(node, level));
                return;
            } else {
                getNode(node.right, x, level + 1);
            }
        }
        return;
    }
} 
*/
