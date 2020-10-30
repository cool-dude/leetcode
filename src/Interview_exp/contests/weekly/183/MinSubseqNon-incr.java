/*
LC1403: Minimum Subsequence in Non-Increasing Order
https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
Given the array nums, obtain a subsequence of the array
whose sum of elements is strictly greater than the s
um of the non included elements in such subsequence.
If there are multiple solutions, return the subsequence
with minimum size and if there still exist multiple solutions,
return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.

Example 1:
Input: nums = [4,3,10,9,8]
Output: [10,9]
Explanation: The subsequences [10,9] and [10,8] are
minimal such that the sum of their elements is strictly
greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements.


Example 2:
Input: nums = [4,4,7,6,7]
Output: [7,7,6]
Explanation: The subsequence [7,7] has the sum of its elements equal
to 14 which is not strictly greater than the sum of elements not
included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is
the minimal satisfying the conditions. Note the subsequence has
to returned in non-decreasing order.  *
 */
class Sln{
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int n= nums.length;
        if(n==0||nums==null)
            return result;
        if(n==1){
            result.add(nums[0]);
            return result;
        }
        int inclSum=0,exSum=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
            exSum +=nums[i];
        for(int i=n-1;i>=0;i--){
            if(nums[i]==0) continue;
            else  {
                inclSum += nums[i];
                exSum -= nums[i];
                result.add(nums[i]);
                if (inclSum > exSum)
                    return result;
            }
        }
        return result;
    }
}