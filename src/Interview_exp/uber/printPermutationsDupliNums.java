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
class Sln{
    void swap(List<Integer> cur, int a, int b){
        Integer temp = cur.get(a);
        cur.set(a,cur.get(b));
        cur.set(b,temp);
    }
    void helper(List<List<Integer>> res, List<Integer> cur , int idx){
        if(idx==cur.size()){
            res.add(new ArrayList<>(cur));
        }
        Set<Integer> set = new HashSet<>();
        for(int i = idx ; i < cur.size() ; i++){
            if(set.add(cur.get(i))){
                swap(cur,i,idx);
                helper(res,cur,index+1);
                swap(cur,i,idx);
            }
        }
    }
    public List<List<Integer>> permuteUniq(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        for(int i:nums){
            cur.add(i);
        }
        helper(result,cur,0);
    }
}