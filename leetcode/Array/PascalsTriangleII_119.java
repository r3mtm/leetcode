/*

TAGS={Array}

119. Pascal's Triangle II


Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> triangle = new ArrayList<>();
        triangle.add(1);
        for (int j = 1; j <= rowIndex; ++j) {
            List<Integer> newBase = new ArrayList<>();
            newBase.add(1);
            for (int i = 0; i < triangle.size(); ++i) {
                if (i + 1 == triangle.size()) {
                    newBase.add(1);
                } else {
                    newBase.add(triangle.get(i) + triangle.get(i + 1));
                }
            }
            triangle = newBase;
        }
        return triangle;
    }
}

public class PascalsTriangleII_119 {
    public static void main(String[] args) {
        int rowIndex = 5;
        System.out.println(new Solution().getRow(rowIndex));
    }
}