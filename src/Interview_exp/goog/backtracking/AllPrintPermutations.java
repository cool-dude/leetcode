/*LC46:Permutation
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
class Sln1{
    List<List<Integer>> res;
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
            res.add(t);
        }
        for(int i=start;i<nums.length;i++){
            swap(nums, i, start);
            helper(nums, start+1);
            swap(num, start, i);
        }
    }
    public List<List<Integer>> permute(int[] nums){
        res=new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        helper(nums, 0);
        return res;
    }
}
/*LC47: Permutations II
* https://leetcode.com/problems/permutations-ii/
Given a collection of numbers that
* might contain duplicates, return all possible unique permutations.
Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/
class Sln2{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }
    void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}