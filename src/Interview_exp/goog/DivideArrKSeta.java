/*LC1296: Divide Array in Sets of K Consecutive Numbers
* https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
Given an array of integers nums and a positive integer k,
* find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

* Example 1:
Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

* Example 2:
Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].

* Example 3:
Input: nums = [3,3,2,2,1,1], k = 3
Output: true

* Example 4:
Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.*/
class Sln{
    public boolean isPossibleDivide(int[] arr,int k){
        if(arr.length%k!=0) return false;
        Map<Integer,Integer> c=new TreeMap<>();
        for(int i:arr) c.put(i,c.getOrDefault(i,0)+1);
        for(int it:c.keySet())
            if(c.get(it) > 0)
                for(int i=k-1;i>=0;i--){
                    if(c.getOrDefault(it+i,0)<c.get(it)) return false;
                    c.put(it+i,c.get(it+i)-c.get(it));
                }
        return true;
    }
    //T:O(nlgn+nk) , n number of different values
    //S:O(n)
}