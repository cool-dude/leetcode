/*40. Combination Sum II
* https://leetcode.com/problems/combination-sum-ii/
* Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
* */
class Sln{
    void combinations(int[] candidates,int idx,int target,List<List<Integer>> result, List<Integer> lst){
        if(target==0){
            result.add(lst);
            return;
        }
        else if(target>0) {
            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i] == candidates[i - 1])
                    continue;
                lst.add(candidates[i]);
                combinations(candidates, i + 1, target - candidates[i], result.lst);
                lst.remove(lst.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
}