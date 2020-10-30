/*LC765: Couples Holding Hands
N couples sit in 2N seats arranged
* in a row and want to hold hands.
* We want to know the minimum number
* of swaps so that every couple is sitting
* side by side. A swap consists of choosing
* any two people, then they stand up and switch seats.

The people and seats are represented by an integer
* from 0 to 2N-1, the couples are numbered in order,
* the first couple being (0, 1), the second couple
* being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.
Example 1:
Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.

* Example 2:
Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.*/
/*
Therefore, for each pivot index i,
its expected index j is given by ptn[pos[ptn[row[i]]]].
As long as i != j, we swap the two elements at index i and j, a
nd continue until the placement requirement is satisfied.
 A minor complication here is that for each swapping operation,
 we need to swap both the row and pos arrays.
 ere is a list of solutions for Java and C++.
 Both run at O(N) time with O(N) space.
  Note that there are several optimizations we can do, just to name a few:

The ptn array can be replaced with a simple function that takes an
index i and returns i + 1 or i - 1 depending on whether i is even or odd.

We can check every other seat instead of all seats.
This is because we are matching each person to
his/her partners, so technically speaking
there are always half of the people sitting at the right seats

There is an alternative way for building the index groups
 which goes in backward direction, that is instead of building
 the cycle like i0 --> i1 --> ... --> jk --> i0, we can also build it like i0 <-- i1 <-- ... <-- ik <-- i0, where i <-- j means the element at index j is expected to appear at index i. In this case, the pivot index will be changing along the cycle as the swapping operations are applied. The benefit is that we only need to do swapping on the row array.
 */
class Sln {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] partner = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            partner[i] = i % 2 == 0 ? i + 1 : i - 1;
            pos[row[i]] = i;
        }
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            int j = i + 1;
            if (row[j] != partner[row[i]]) {
                j = pos[partner[row[i]]];
                swap(row, i+1, j);
                swap(pos, row[i+1], row[j]);
                res++;
            }
        }
        return res;
    }
    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}