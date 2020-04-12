import java.util.PriorityQueue;
import java.util.Comparator;

/*

TAGS={Heap, Greedy}

1046. Last Stone Weight

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.
Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }
        while(heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();
            // System.out.println(a + " " + b);
            // System.out.println("Size = " + heap.size() + "\n");
            int c = Math.abs(a- b);
            if (c != 0) {
                heap.add(c);
            } 
        }
        if (heap.size() == 0) {
            return 0;
        } else {
            return heap.peek();
        }
    }
}

public class LastStoneWeight_1046 {
    public static void main (String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new Solution().lastStoneWeight(stones));
    }
}
 