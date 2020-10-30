/*LC169: Majority Element
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
class Sln1{
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
/*LC229: Majority Element II
https://leetcode.com/problems/majority-element-ii/
Given an integer array of size n,
find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]*/
class Sln2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        int num1 = nums[0]; int num2 = nums[0]; int count1 = 0; int count2 = 0 ;
        for (int val : nums) {
            if(val == num1)
                count1++;
            else if (val == num2)
                count2++;
            else if (count1 == 0) {
                num1 = val;
                count1++;
            }
            else if (count2 == 0) {
                num2 = val;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0,count2=0;
        for(int val:nums){
            if(val==num1)
                count1++;
            else if(val==num2)
                count2++;
        }
        if(count1 > nums.length/3)
            res.add(num1);
        if(count2 > nums.length/3)
            res.add(num2);
        return res;
    }
}