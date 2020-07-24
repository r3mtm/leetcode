/*

TAGS={Depth-first Search}

797. All Paths From Source to Target


Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:

Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3

There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.


Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.


*/


import java.util.ArrayList;
import java.util.List;

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<>();
        dfs(graph, 0, tempList);
        return result;
    }
    
    private void dfs(int[][] graph, int index, List<Integer> tempList) {
        
        tempList.add(index);
        
        if (graph.length == index + 1) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        int[] arr = graph[index];
        int i;
        for (i = 0; i < arr.length; ++i) {
            dfs(graph, arr[i], tempList);
            tempList.remove((int)tempList.size() - 1);
        }
        
    }
}

public class AllPathsFromSourceToTarget_797 {
    public static void main(String[] args) {
        int[][] graph = {
            {1,2}, {3}, {3}, {}
        };
        
        List<List<Integer>> result = new Solution().allPathsSourceTarget(graph);

        for (List<Integer> sublist : result) {
            for (int num : sublist) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}