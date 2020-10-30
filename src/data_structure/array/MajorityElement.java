/*
* LC169: Majority Element
Given an array of size n,
* find the majority element.
* The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty
* and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2*/
class Sln{
    public int majorityElement(int[] nums) {
        int n=nums.length;
        for(int num:nums){
            int count=0;
            for(int elm:nums){
                if(elm==num){
                    count++;
                }
            }
            if(count>n/2){
                return num;
            }
        }
        return -1;
    }
    //T:O(n^2).
    //S:O(1).

    public int majorityElement(int[] nums){
        int count=0;
        int cand=-1;
        for(int num:nums){
            if(count==0){
                cand=num;
            }
            count+=(cand==num)?1:-1;
        }
        return cand;
    }
    //T:O(n).
    //S:O(1).
}