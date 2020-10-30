package backtracking;
/*LC46. Permutation
https://leetcode.com/problems/permutations/
Given a collection of distinct integers,
return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/
class Sln{
    List<List<Integer>> result;
    void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    void helper(int[] nums, int start){
        if(start==nums.length-1){
            List<Integer> t=new ArrayList<>();
            for(int num:nums){
                t.add(num);
            }
            result.add(t);
        }
        for(int i=start;i<nums.length;i++){
            swap(nums, i, start);
            helper(nums, start+1);
            swap(num, start, i);
        }
    }
    public List<List<Integer>> permute(int[] nums){
        result=new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        helper(nums, 0);
        return result;
    }
}