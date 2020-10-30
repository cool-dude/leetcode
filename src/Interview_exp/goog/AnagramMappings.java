/*LC760:Anagram mappings
https://leetcode.com/problems/find-anagram-mappings/
Given two lists A and B, and B is an anagram of A.
 B is an anagram of A means B is made by
 randomizing the order of the elements in A.
We want to find an index mapping P, from A to B.
 A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given
A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]*/
class Sln{
    public int[] findMappings(int[] A,int[] B){
        if(A.length==0||A==null||B.length==0||B==null)
            return new int[]{0};
        int n=A.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(B[i],i);
        int[] res=new int[n];
        for(int i=0;i<n;i++)
            res[i]=map.get(A[i]);
        return res;
    }
    //T:O(n).
    //S:O(n).
}