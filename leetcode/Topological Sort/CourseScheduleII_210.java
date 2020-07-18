/*

TAGS={Depth-first Search, Breadth-first Search, Graph, Topological Sort}

210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .


Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.


*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

class Solution {
    
    Map<Integer, List<Integer>> map;
    List<Integer> coursesList;
    Set<Integer> checkSet;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        coursesList = new ArrayList<>();
        map = new HashMap<>();
        checkSet = new HashSet<>();
        
        for (int[] course : prerequisites) {
            map.putIfAbsent(course[0], new ArrayList<>());
            map.get(course[0]).add(course[1]);
        }
        
        int i = 0;
        while (coursesList.size() < numCourses && i < prerequisites.length) {
            Set<Integer> set = new HashSet<>();
            if (!dfs(set, prerequisites[i][0])) return new int[0];
            ++i;
        }
        
        if (coursesList.size() < numCourses) {
            for (i = 0; i < numCourses; ++i) {
                if (!checkSet.contains(i)) coursesList.add(i);
            }
        }
        
        int[] result = new int[coursesList.size()];
        for (i = 0; i < coursesList.size(); i++){
            result[i] = coursesList.get(i);
        }
        
        return result;
    }
    
    private boolean dfs(Set<Integer> set, int course) {
        if (set.contains(course)) {
            coursesList.clear();
            return false;
        }
        set.add(course);
        List<Integer> list = map.getOrDefault(course, null);
        
        if (list == null) {
            if (!checkSet.contains(course)) {
                coursesList.add(course);
                checkSet.add(course);
            }
            return true;
        }
        
        for (int num : list) {
            if (!checkSet.contains(num)) {
                if (!dfs(set, num)) return false;
            }
            
        }
        
        if (!checkSet.contains(course)) {
            coursesList.add(course);
            checkSet.add(course);
        }
        return true;
    }
}

public class CourseScheduleII_210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };

        int[] result = new Solution().findOrder(numCourses, prerequisites);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
