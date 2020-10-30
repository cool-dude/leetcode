/*LC763: Partition Labels
https://leetcode.com/problems/partition-labels/
A string S of lowercase English letters is given.
We want to partition this string into as many parts
as possible so that each letter appears in at most
one part, and return a list of integers representing
the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:
S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.*/
class Sln{
    public List<Integer> partitionLabels(String s){
        if(s==null||s.length()==0)
            return null;
        List<Integer> lst=new ArrayList<>();
        int[] map=new int[26];
        for(int i=0;i<s.length();i++)
            map[s.charAt(i)-'a']=i;
        int last=0,start=0;
        for(int i=0;i<s.length();i++){
            last=Math.max(last,map[s.charAt(i)-'a']);
            if(last==i){
                lst.add(last-start+1);
                start=last+1;
            }
        }
        return lst;
    }
}