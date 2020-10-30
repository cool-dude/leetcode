/*LC702:Search in a Sorted Array of Unknown Size
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
Given an integer array sorted in ascending order,
write a function to search target in nums.
 If target exists, then return its index,
otherwise return -1. However, the array
size is unknown to you. You may only access
the array using an ArrayReader interface,
where ArrayReader.get(k) returns the element
of the array at index k (0-indexed).
You may assume all integers in the array are
less than 10000, and if you access the
array out of bounds, ArrayReader.get
will return 2147483647.
Example 1:
Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is
Example 2:
Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
Constraints:
You may assume that all elements in the array are unique.
The value of each element in the array will be in the range [-9999, 9999].
The length of the array will be in the range [1, 10^4].*/
class Sln{
    public int search(ArrayReader rdr,int target){
        int hi=1;
        while (rdr.get(hi)<target)
            hi=hi<<1;
        int lo=hi>>1;
        while (lo<=hi){
            int mi=lo+(hi-lo)/2;
            if(rdr.get(mi)>target)
                hi=mi-1;
            else if(rdr.get(mi)<target)
                lo=mi+1;
            else
                return mi;
        }
        return -1;
    }
}