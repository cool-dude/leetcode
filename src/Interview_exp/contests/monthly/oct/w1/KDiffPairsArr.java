/*LC532: K-diff Pairs in an Array
https://leetcode.com/problems/k-diff-pairs-in-an-array/
Given an array of integers nums and an integer k,
return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
0 <= i, j < nums.length
i != j
a <= b
b - a == k
Example 1:
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:
Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

Example 4:
Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
Output: 2

Example 5:
Input: nums = [-1,-2,-3], k = 1
Output: 2
Constraints:
1 <= nums.length <= 104
-107 <= nums[i] <= 107
0 <= k <= 107*/
class Sln {
    public int findPairs(int[] nums, int k) {
        if(nums.length==0||nums==null||k<0)
            return 0;
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums) {
            if (map.containsKey(i)) {
                if (k == 0 && map.get(i)==1)
                    res++;
                map.put(i, map.get(i) + 1);
            }
            else {
                if(map.containsKey(i-k))
                    res++;
                if(map.containsKey(i+k))
                    res++;
                map.put(i,1);
            }
        }
        return res;
    }
}