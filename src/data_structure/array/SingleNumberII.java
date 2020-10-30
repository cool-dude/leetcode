/*
LC137: Single Number II
https://leetcode.com/problems/single-number-ii/
Given a non-empty array of integers, every element
appears three times except for one, which appears
exactly once. Find that single one.

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99*/
class Sln{
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) {
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }
        for (int k : hMap.keySet()) {
            if (hashmap.get(k) == 1) return k;
        }
        return -1;
    }
    //T:O(n).
    //S:O(n).
}