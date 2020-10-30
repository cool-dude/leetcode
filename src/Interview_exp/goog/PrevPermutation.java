/*
* LC1053: Previous Permutation With One Swap
Given an array A of positive integers
* (not necessarily distinct), return
*  the lexicographically largest permutation
* that is smaller than A, that can be made
* with one swap (A swap exchanges the positions
* of two numbers A[i] and A[j]).
* If it cannot be done, then return the same array.
Example 1:
Input: [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.
*
Example 2:
Input: [1,1,5]
Output: [1,1,5]
Explanation: This is already
* smallest permutation.

* Example 3:
Input: [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.

* Example 4:
Input: [3,1,1,3]
Output: [1,3,1,3]
Explanation: Swapping 1 and 3.*/
class Sln {
    public int[] prevPermOpt1(int[] A) {
        if (A.length <= 1) return A;
        int idx = -1;
        // find the largest i such that A[i] > A[i + 1]
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i] < A[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        // the array already sorted, not smaller permutation
        if (idx == -1) return A;
        // find the largest j such that A[j] > A[i], then swap them
        for (int i = A.length - 1; i > idx; i--) {
            // the second check to skip duplicate numbers
            if (A[i] < A[idx] && A[i] != A[i - 1]) {
                int tmp = A[i];
                A[i] = A[idx];
                A[idx] = tmp;
                break;
            }
        }
        return A;
    }
}