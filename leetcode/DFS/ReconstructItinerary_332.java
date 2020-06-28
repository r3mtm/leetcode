/*

TAGS={Depth-first Search, Graph}

332. Reconstruct Itinerary

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. 
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.


Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]


Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.

*/

class Solution {
    
    Map<String, Queue<String>> map;
    LinkedList<String> itinerary;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        itinerary = new LinkedList<>();
        
        for (List<String> item : tickets) {
            // System.out.println(item.get(0) + " " + item.get(1));
            map.putIfAbsent(item.get(0), new PriorityQueue<>());
            map.get(item.get(0)).add(item.get(1));
        }
        checkLocHasDst("JFK"); //start
        return itinerary;
    }
    
    private void checkLocHasDst(String arrival) {
        Queue<String> queue = map.get(arrival);
        
        while (queue != null && queue.size() > 0) {
            checkLocHasDst(queue.poll());
        }
        itinerary.addFirst(arrival);
    }
}