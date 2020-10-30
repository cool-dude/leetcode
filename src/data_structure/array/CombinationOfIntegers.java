/*
* LC:77: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
* */
class Sln {
    List<List<Integer>> result;
    public void combinationHelper(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        else {
            for (int i = start; i <= n; i++) {
                //change
                list.add(i);
                //explore
                combinationHelper(i + 1, n, k, list);
                //unchange
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        combinationHelper(1, n, k, new ArrayList<>());
        return result;
    }
}