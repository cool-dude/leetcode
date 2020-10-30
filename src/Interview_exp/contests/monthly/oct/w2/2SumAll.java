/*LC1: Two Sum
https://leetcode.com/problems/two-sum/
Given an array of integers, return indices
of the two numbers such that they add up to a specific target.
You may assume that each input would
have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]*/
class Sln {
    public static int[] twoSum(int[] nums, int target) {
        // int difference = target - nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            else
                map.put(nums[i], i);
        }
        return new int[]{};
    }
}
/*LC167: Two Sum II - Input array is sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Given an array of integers that is already
sorted in ascending order, find two numbers
such that they add up to a specific target number.
The function twoSum should return indices of the two
numbers such that they add up to the target,
where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2)
are not zero-based.
You may assume that each input would have exactly
one solution and you may not use the same element twice.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9.
Therefore index1 = 1, index2 = 2.*/
class Sln2 {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int l=0,r=n-1;
        while (l<=r){
            if(numbers[l]+numbers[r]<target) {
                l++;
            }
            else if(numbers[l]+numbers[r]>target){
                r--;
            }
            else {
                return new int[]{l,r};
            }
        }
        return new int[]{-1,-1};
    }
}
/*LC170: Two Sum III - Data structure design
https://leetcode.com/problems/two-sum-iii-data-structure-design/
Design a data structure that accepts a stream
of integers and checks if it has a pair of
integers that sum up to a particular value.
Implement the TwoSum class:
TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there
exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
Example 1:
Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false
Constraints:
-105 <= number <= 105
-231 <= value <= 231 - 1
At most 5 * 104 calls will be made to add and find.*/
class Sln3 {
    List<Integer> list = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)) map.put(number, map.get(number) + 1);
        else {
            map.put(number, 1);
            list.add(number);
        }
    }
    // Find if there exists any pair
    // of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++){
            int num1 = list.get(i), num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
        }
        return false;
    }
}