/*https://www.hackerrank.com/challenges/crush/problem
Starting with a 1-indexed array of zeros and a list of operations,
for each operation add a value to each of the array
element between two given indices, inclusive.
Once all operations have been performed,
return the maximum value in the array.
Example
Queries are interpreted as follows:
    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:
index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is  after all operations are performed.*/
package hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Sln {
    static void update(long D[], int l, int r, int x) {
        D[l] += x;
        D[r + 1] -= x;
    }
    static long arrayManipulation(int n, int[][] queries) {
        long max = Integer.MIN_VALUE;
        long[] D = new long[n + 1];
        long[] A = new long[n];
        D[0] = A[0];
        D[n] = 0L;
        for (int i = 1; i < n; i++)
            D[i] = A[i] - A[i - 1];
        for (int[] q:queries) {
            update(D, q[0] - 1, q[1] - 1, q[2]);
        }
        for (int i = 0; i < A.length; i++) {
            if (i == 0)
                A[i] = D[i];
            else {
                A[i] = D[i] + A[i - 1];
                if (A[i] > max)
                    max = A[i];
            }
        }
        return max;
    }
}