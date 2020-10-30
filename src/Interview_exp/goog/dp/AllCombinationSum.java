/*LC39: Combination Sum
https://leetcode.com/problems/combination-sum/
Given a set of candidate numbers (candidates)
(without duplicates) and a target number (target),
find all unique combinations in candidates where
the candidate numbers sums to target.
The same repeated number may be chosen
from candidates unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
Constraints:
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
Each element of candidate is unique.
1 <= target <= 500*/
class Sln {
    List<List<Integer>> res;
    int[] cands;
    private void calcCombinations(int idx, List<Integer> lst, int tgt){
        if(tgt==0){
            res.add(lst);
            return;
        }
        for(int i=idx;i<cands.length;i++){
            if(tgt-cands[i]>=0){
                List lst1=new LinkedList(lst);
                lst1.add(cands[i]);
                calcCombinations(i, lst1, tgt-cands[i]);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] cands, int tgt){
        res = new LinkedList<List<Integer>>();
        if(cands.length==0) return res;
        this.cands = cands;
        List<Integer> list=new LinkedList<Integer>();
        calcCombinations(0, list, tgt);
        return res;
    }
}
/*LC40: Combination Sum II
https://leetcode.com/problems/combination-sum-ii/
Given a collection of candidate numbers
(candidates) and a target number (target),
find all unique combinations in candidates
where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
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
]*/
class Sln2 {
    void combinations(int[] cands,int idx, int target, List<List<Integer>> result, List<Integer> lst){
        if(target==0){
            result.add(new ArrayList<>(lst));
        }
        if(target<0) return;
        for(int i=idx;i<cands.length;i++){
            if(i>idx && cands[i]==cands[i-1]) {
                continue;
            }
            lst.add(cands[i]);
            combinations(cands, i+1, target-cands[i], result, lst);
            lst.remove(lst.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
}
/*LC216: Combination Sum III
https://leetcode.com/problems/combination-sum-iii/
Find all valid combinations of k numbers
that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations.
The list must not contain the same combination twice,
and the combinations may be returned in any order.
Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.

Example 4:
Input: k = 3, n = 2
Output: []
Explanation: There are no valid combinations.

Example 5:
Input: k = 9, n = 45
Output: [[1,2,3,4,5,6,7,8,9]]
Explanation:
1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
​​​​​​​There are no other valid combinations.*/
class Sln3{
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }
    void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
/*LC377: Combination Sum IV
https://leetcode.com/problems/combination-sum-iv/
Given an integer array with all positive numbers
and no duplicates, find the number of possible
combinations that add up to a positive integer target.
Example:
nums = [1, 2, 3]
target = 4
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
Think about the recurrence relation first. How does the # of combinations
of the target related to the # of combinations of numbers that are smaller than the target?
So we know that target is the sum of numbers in the array.
Imagine we only need one more number to reach target,
this number can be any one in the array, right?
So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]),
where 0 <= i < nums.length, and target >= nums[i].

In the example given, we can actually find the # of combinations
of 4 with the # of combinations of 3(4 - 1), 2(4- 2) and 1(4 - 3).
As a result, comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + comb[1].

Then think about the base case. Since if the target is 0,
there is only one way to get zero, which is using 0, we can set comb[0] = 1.

EDIT: The problem says that target is a positive integer
that makes me feel it's unclear to put it in the above way.
Since target == 0 only happens when in the previous call, target = nums[i],
we know that this is the only combination in this case, so we return 1.
Now we can come up with at least a recursive solution.*/
class Sln4{
    public int combinationSum4(int[] nums,int target){
        if(target==0)
            return 1;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i]){
                res+=combinationSum4(nums,target-nums[i]);
            }
        }
        return res;
    }
}

class Sln5{
    int[] dp;
    int helper(int[] nums,int target){
        if(dp[target]!=-1)
            return dp[target];
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i])
                res+=helper(nums,target-nums[i]);
        }
        dp[target]=res;
        return dp[target];
    }
    public int combSum4(int[] nums,int target){
        dp=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        return helper(nums,target);
    }
}

class Sln6{
    public int combinationSum4(int[] nums,int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j]){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}