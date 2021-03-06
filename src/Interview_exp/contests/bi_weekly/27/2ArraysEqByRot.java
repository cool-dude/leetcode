/*LC1460: Make Two Arrays Equal by Reversing Sub-arrays
https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
Given two integer arrays of equal length target and arr.
In one step, you can select any non-empty sub-array
of arr and reverse it. You are allowed to make any
number of steps.

Return True if you can make arr
equal to target, or False otherwise
Example 1:
Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true

Example 2:
Input: target = [7], arr = [7]
Output: true
Explanation: arr is equal to target without any reverses.

Example 3:
Input: target = [1,12], arr = [12,1]
Output: true

Example 4:
Input: target = [3,7,9], arr = [3,7,11]
Output: false.

Example 5:
Input: target = [1,1,1,1,1], arr = [1,1,1,1,1]
Output: true*/
class Sln {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n=arr.length;
        int[] count=new int[1001];
        for(int i=0;i<n;i++)
            count[target[i]]++;
        for(int i=0;i<n;i++) {
            count[arr[i]]--;
            if (count[arr[i]] < 0)
                return false;
        }
        return true;
    }
}