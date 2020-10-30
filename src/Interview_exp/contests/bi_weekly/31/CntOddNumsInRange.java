/*LC1523: Count Odd Numbers in an Interval Range
https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
Given two non-negative integers low and high.
Return the count of odd numbers between low and high (inclusive).

Example 1:
Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].*/
class Sln {
    public int countOdds(int low, int high) {
        //num of odds b/w 1 and low-1: low/2
        //num of odds b/w 1 and high: high+1/2
        return (high+1)/2-low/2;
    }
}