/*

TAGS={Dynamic Programming, Binary Search}

174. Dungeon Game

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and
must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	   3
-5	    -10	   1
10	     30	  -5 (P)
 

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

*/

class Solution {
    // 2ms solution
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        int[][] minMap = new int[row][col];

        // last cell in matrix (Princess)
        if (dungeon[row - 1][col - 1] < 0) {
            minMap[row - 1][col - 1] = dungeon[row - 1][col - 1] * -1 + 1;
        }

        // last row
        for (int i = col - 2; i >= 0; --i) {
            if (dungeon[row - 1][i] < 0) {
                minMap[row - 1][i] = dungeon[row - 1][i] * -1 + (minMap[row - 1][i + 1] == 0 ? 1 : minMap[row - 1][i + 1]);
            } else {
                if (dungeon[row - 1][i] >= minMap[row - 1][i + 1]) {
                    minMap[row - 1][i] = 0;
                } else {
                    minMap[row - 1][i] = minMap[row - 1][i + 1] - dungeon[row - 1][i];
                }
            }
        }

        // last column
        for (int i = row - 2; i >= 0; --i) {
            if (dungeon[i][col - 1] < 0) {
                minMap[i][col - 1] = dungeon[i][col - 1] * -1 + (minMap[i + 1][col - 1] == 0 ? 1 : minMap[i + 1][col - 1]);
            } else {
                if (dungeon[i][col - 1] >= minMap[i + 1][col - 1]) {
                    minMap[i][col - 1] = 0;
                } else {
                    minMap[i][col - 1] = minMap[i + 1][col - 1] - dungeon[i][col - 1];
                }
            }
        }

        // rest of the matrix
        for (int i = row - 2; i >= 0; --i) {
            for (int j = col - 2; j >= 0; --j) {
                int min = (minMap[i + 1][j] < minMap[i][j + 1]) ? minMap[i + 1][j] : minMap[i][j + 1];

                if (dungeon[i][j] < 0) {
                    minMap[i][j] = dungeon[i][j] * -1 + (min == 0 ? 1 : min);
                } else {
                    if (dungeon[i][j] >= min) {
                        minMap[i][j] = 0;
                    } else {
                        minMap[i][j] = min - dungeon[i][j];
                    }
                }
            }
        }
        return minMap[0][0] == 0 ? 1 : minMap[0][0];
    }
}

public class DungeonGame_174 {
    public static void main(String[] args) {
        int[][] dungeon = {
                {2},{1}
            };
        System.out.println(new Solution().calculateMinimumHP(dungeon));
    }
}