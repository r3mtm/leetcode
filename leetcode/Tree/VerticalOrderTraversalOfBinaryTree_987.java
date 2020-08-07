/*

TAGS={Hash Table, Tree}

987. Vertical Order Traversal of a Binary Tree


Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.


Example 1:

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).


Example 2:

Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.

Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.


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
    
    class Item {
        TreeNode node;
        int x;
        
        public Item(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }
    
    Map<Integer, List> map;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<Item> queue = new LinkedList<>();
        map = new HashMap<>();
        queue.add(new Item(root, 0));
        
        while (!queue.isEmpty()) {
            
            Queue<Item> newQueue = new LinkedList<>();
            Map<Integer, Queue> tempMap = new HashMap<>();
            
            while (!queue.isEmpty()) {
                Item item = queue.poll();
                
                tempMap.putIfAbsent(item.x, new PriorityQueue());
                tempMap.get(item.x).add(item.node.val);
                
                if (item.node.left != null) {
                    newQueue.add(new Item(item.node.left, item.x - 1));
                }
                
                if (item.node.right != null) {
                    newQueue.add(new Item(item.node.right, item.x + 1));
                }
            }
            
            for (Map.Entry<Integer, Queue> entry : tempMap.entrySet()) {
                Queue<Integer> q = entry.getValue();
                map.putIfAbsent(entry.getKey(), new ArrayList<>());
                while(!q.isEmpty()) {
                    map.get(entry.getKey()).add(q.poll());
                }
            }
            queue = newQueue;
        }
        
        
        PriorityQueue<Map.Entry<Integer, List>> queueSorted = new PriorityQueue<>((e1, e2) -> {
            return e1.getKey() - e2.getKey();
        });
        
        for (Map.Entry<Integer, List> entry : map.entrySet()) {
            queueSorted.add(entry);
        }
        
        while (!queueSorted.isEmpty()) {
            result.add(queueSorted.poll().getValue());
        }
        
        return result;
    }   
}