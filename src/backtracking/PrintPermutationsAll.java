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
class Sln1{
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