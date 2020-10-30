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
class Sln {
    List<List<Integer>> output = new ArrayList();
    int n,k;
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k <= n; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
    //T:O(NX2^N).
    //S:O(NX2^N)
}