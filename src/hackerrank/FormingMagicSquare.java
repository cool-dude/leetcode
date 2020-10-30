/*We define a magic square to be an
matrix of distinct positive integers from
to  where the sum of any row, column,
or diagonal of length  is always equal
to the same number: the magic constant.
You will be given a  matrix  of integers
in the inclusive range . We can convert
any digit  to any other digit  in the
range  at cost of . Given , convert
it into a magic square at minimal cost.
Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range .
Example
$s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]

The matrix looks like this:
5 3 4
1 5 8
6 4 2
We can convert it to the following magic square:
8 3 4
1 5 9
6 7 2
This took three replacements at a cost of 7*/
package hackerrank;
import java.util.*;
public class FormingMagicSquare {
    static int formingMagicSquare(int[][] s) {
        int cost = Integer.MAX_VALUE;
        int t[][] =
                {
                        {4,9,2,3,5,7,8,1,6},
                        {4,3,8,9,5,1,2,7,6},
                        {2,9,4,7,5,3,6,1,8},
                        {2,7,6,9,5,1,4,3,8},
                        {8,1,6,3,5,7,4,9,2},
                        {8,3,4,1,5,9,6,7,2},
                        {6,7,2,1,5,9,8,3,4},
                        {6,1,8,7,5,3,2,9,4},
                };
        int temp = 0;
        for(int i=0;i<8;i++){
            temp = Math.abs(s[0][0]-t[i][0])
                    + Math.abs(s[0][1]-t[i][1])
                    + Math.abs(s[0][2]-t[i][2])
                    + Math.abs(s[1][0]-t[i][3])
                    + Math.abs(s[1][1]-t[i][4])
                    + Math.abs(s[1][2]-t[i][5])
                    + Math.abs(s[2][0]-t[i][6])
                    + Math.abs(s[2][1]-t[i][7])
                    + Math.abs(s[2][2]-t[i][8]);
            cost = temp<cost?temp:cost;
        }
        return cost;
    }
}