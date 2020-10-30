package practice.backtracking;
import java.util.ArrayList;
import java.util.List;
/*LC78: Subsets
* https://leetcode.com/problems/subsets/
Given a set of distinct integers, nums,
* return all possible subsets (the power set).
Note: The solution set must not contain
* duplicate subsets.
Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
class Sln1 {
    int k;
    public void backtrack(int first, List<Integer> cur, int[] nums, List<List<Integer>> res, int n) {
        // combination is done
        if (cur.size() == k)
            res.add(new ArrayList(cur));
        for (int i = first; i < n; i++) {
            // add i into the current combination
            cur.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, cur, nums);
            // backtrack
            cur.remove(cur.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0||nums==null) return res;
        int n = nums.length;
        for (k = 0; k <= n; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums, res, n);
        }
        return res;
    }
    //T:O(NX2^N).
    //S:O(NX2^N)
}
/*LC90. Subsets II
https://leetcode.com/problems/subsets-ii/
Given a collection of integers that might
contain duplicates, nums, return all possible subsets (the power set).
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
class Sln {
    void generate(int i, int[] nums, List<List<Integer>> res,
                  List<Integer> tmp, Set<List<Integer>> set) {
        if (i == nums.length) return;
        tmp.add(nums[i]);
        if (!set.contains(tmp)) {
            set.add(tmp);
            res.add(new ArrayList(tmp));
        }
        generate(i + 1, nums, res, tmp, set);
        tmp.remove(tmp.size() - 1);
        generate(i + 1, nums, res, tmp, set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        res.add(new ArrayList(tmp));
        generate(0, nums, res, tmp, set);
        return res;
    }
}