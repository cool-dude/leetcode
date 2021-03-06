/*LC386: Lexicographical Numbers
https://leetcode.com/problems/lexicographical-numbers/
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less
time and space. The input size may be as
large as 5,000,000.
The idea is pretty simple. If we look at the
order we can find out we just keep adding
digit from 0 to 9 to every digit and make it a tree.
Then we visit every node in pre-order.
       1        2        3    ...
      /\        /\       /\
   10 ...19  20...29  30...39   ...*/
class Sln {
    void dfs(int cur,int n,List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;i++){
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i,n,res);
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<10;i++)
            dfs(i,n,res);
        return res;
    }
}