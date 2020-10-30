/*LC77: Combination
https://leetcode.com/problems/combinations/
Given two integers n and k,
return all possible combinations
 of k numbers out of 1 ... n.
Example:
Input: n = 4, k = 2
Output:
[[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4]]*/
import java.util.ArrayList;
import java.util.List;
class Sln{
    void helper(int start,int n,int k,
                List<Integer> lst, List<List<Integer>> result){
        if(lst.size()==k){
            result.add(lst);
            return;
        }
        else {
            for(int i=start;i<=n;i++){
                lst.add(i);
                helper(start+1,n,k,lst,result);
                lst.remove(lst.size()-1);
            }
        }
    }
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> lst=new ArrayList<>();
        helper(1,n,k,lst,result);
        return result;
    }
}