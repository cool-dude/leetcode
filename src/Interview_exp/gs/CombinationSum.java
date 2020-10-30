/*LC39: Combination Sum
* https://leetcode.com/problems/combination-sum/
* Set of candidate numbers (candidates) (without duplicates)
* and a target number (target), find all unique combinations in candidates
* where the candidate numbers sums to target.
The same repeated number may be chosen
* from candidates unlimited number of times.

* Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
* Ex1:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
* Ex2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]*/
class Sln{
    List<List<Integer>> res;
    int[] candidates;
    void backtrack(int idx,List<Integer> lst,int tgt){
        if(tgt==0){
            res.add(lst);
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(tgt - candidates[i]>=0){
                List l=new LinkedList(lst);
                l.add(candidates[i]);
                backtrack(i,l,tgt-candidates[i]);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int tgt){
        res=new LinkedList<List<Integer>>();
        if(nums.length==0) return res;
        candidates=nums;
        backtrack(0,new LinkedList<Integer>, tgt);
        return res;
    }
}