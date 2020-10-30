/*LC760:Anagram mappings
https://leetcode.com/problems/find-anagram-mappings/
Given two lists Aand B, and B is an anagram of A.
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
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(A[i]==B[j])
                    res[i]=j;
        return res;
    }
    //T:O(n^2).
    //S:O(1).
}