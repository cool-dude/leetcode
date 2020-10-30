/*Given an array of integers, 1 ≤ a[i] ≤ n
(n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]*/
class Sln{
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])]>=0)
                nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
            else
                res.add(Math.abs(nums[i]));
        }
        return res;
    }
}