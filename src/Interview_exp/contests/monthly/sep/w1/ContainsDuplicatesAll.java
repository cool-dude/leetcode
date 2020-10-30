/*LC217: Contains Duplicate
https://leetcode.com/problems/contains-duplicate/
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least
twice in the array, and it should return false if every element is distinct.
Example 1:
Input: [1,2,3,1]
Output: true

Example 2:
Input: [1,2,3,4]
Output: false

Example 3:
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true*/
class Sln1 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dist=new HashSet<Integer>();
        for(int num:nums){
            if(dist.contains(num))
                return true;
            dist.add(num);
        }
        return false;
    }
}
/*LC219: Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/
Given an array of integers and an integer k,
find out whether there are two distinct indices
i and j in the array such that nums[i] = nums[j]
and the absolute difference between i and j is at most k.
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
Explanation: It iterates over the array using a sliding window.
The front of the window is at i, the rear of the window is k
steps back. The elements within that window are maintained
using a Set. While adding new element to the set, if add()
returns false, it means the element already exists in the set.
At that point, we return true. If the control reaches out of for loop,
it means that inner return true never executed, meaning
no such duplicate element was found.*/
class Sln2{
    public boolean containsNearbyDuplicate(int[] nums,int k){
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(i>k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
/*LC220: Contains Duplicate III
https://leetcode.com/problems/contains-duplicate-iii/
Given an array of integers, find out
whether there are two distinct indices
i and j in the array such that the absolute
difference between nums[i] and nums[j]
is at most t and the absolute difference
between i and j is at most k.
Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false*/
class Sln3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}