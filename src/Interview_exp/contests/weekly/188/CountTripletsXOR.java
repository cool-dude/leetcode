/*LC1442: Count Triplets That Can Form
Two Arrays of Equal XOR
Given an array of integers arr.
We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.
Example 1:
Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

Example 2:
Input: arr = [1,1,1,1,1]
Output: 10
Example 3:

Input: arr = [2,3]
Output: 0

Example 4:
Input: arr = [1,3,5,7,9]
Output: 3

Example 5:
Input: arr = [7,11,12,9,5,2,7,17,22]
Output: 8*/
/*
Give the observation: For all pairs of i and k,
where arr[i] ^ arr[i + 1] ^ ... ^ arr[k] = 0,
then any j (i < j <= k) will be good to set as
the answer (hint: proof by contradiction,
if you cannot understand this trick immediately).
So you just need to find all segments where XOR equals zero. */
class Sln {
    public int countTriplets(int[] arr) {
        int ans = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    ans += (j - i);
                }
            }
        }
        return ans;
    }
}