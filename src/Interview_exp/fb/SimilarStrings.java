/*LC39: Similar String Groups
https://leetcode.com/problems/similar-string-groups/
Two strings X and Y are similar if
* we can swap two letters (in different
* positions) of X, so that it equals Y.
*  Also two strings X and Y are similar
* if they are equal.

For example, "tars" and "rats" are similar
(swapping at positions 0 and 2), and
* "rats" and "arts" are similar,
* but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity:
* {"tars", "rats", "arts"} and {"star"}.
*  Notice that "tars" and "arts" are in the same
* group even though they are not similar.
* Formally, each group is such that a word is in the group
* if and only if it is similar to at least one other word in the group.

We are given a list A of strings.
* Every string in A is an anagram of
*  every other string in A.  How many groups are there?
Example 1:
Input: A = ["tars","rats","arts","star"]
Output: 2*/
class Sln{
    boolean areSimilar(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        int difCount=0;
        int[] difIndices=new int[2];
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(difCount==2)
                    return false;
                difIndices[difCount++]=i;
            }
        }
        return difCount==0||(difCount==2 &&
                s1.charAt(difIndices[0])==s2.charAt(difIndices[1]) &&
                s1.charAt(difIndices[1])==s2.charAt(difIndices[0]));
    }
    //T:O(N).
}
class Sln {
    public int numSimilarGroups(String[] A) {
        int N = A.length;
        int W = A[0].length();
        DSU dsu = new DSU(N);

        if (N < W*W) { // If few words, then check for pairwise similarity: O(N^2 W)
            for (int i = 0; i < N; ++i)
                for (int j = i+1; j < N; ++j)
                    if (similar(A[i], A[j]))
                        dsu.union(i, j);
        }
        else { // If short words, check all neighbors: O(N W^3)
            Map<String, List<Integer>> buckets = new HashMap();
            for (int i = 0; i < N; ++i) {
                char[] L = A[i].toCharArray();
                for (int j0 = 0; j0 < L.length; ++j0)
                    for (int j1 = j0 + 1; j1 < L.length; ++j1) {
                        swap(L, j0, j1);
                        StringBuilder sb = new StringBuilder();
                        for (char c: L) sb.append(c);
                        buckets.computeIfAbsent(sb.toString(),
                                x-> new ArrayList<Integer>()).add(i);
                        swap(L, j0, j1);
                    }
            }
            for (int i1 = 0; i1 < A.length; ++i1)
                if (buckets.containsKey(A[i1]))
                    for (int i2: buckets.get(A[i1]))
                        dsu.union(i1, i2);
        }
        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (dsu.parent[i] == i) ans++;
        return ans;
    }
    public boolean similar(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); ++i)
            if (word1.charAt(i) != word2.charAt(i))
                diff++;
        return diff <= 2;
    }
    public void swap(char[] A, int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
class DSU {
    int[] parent;
    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
class DSU{
    int[] parent;
    public DSU(int N){
        parent=new int[N];
        for(int i=0;i<N;i++)
            parent[i]=i;
    }
    public int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int x,int y){
        parent[find((x))]=find(y);
    }
}
class Sln{
    boolean similar(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); ++i)
            if (word1.charAt(i) != word2.charAt(i))
                diff++;
        return diff <= 2;
    }
    void swap(char[] A, int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public int numSimilarGroups(String[] A){
        int N=A.length;
        int W= A[0].length;
        DSU dsu = new DSU(N);

        if(N<W^2){
            // If few words, then check for pairwise similarity: O(N^2 W)
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    if(similar(A[i],A[j]))
                        dsu.union(i,j);
                }
            }
        }
        // If short words, check all neighbors: O(N W^3)
        else {
            Map<String, List<Integer>> buckets = new HashMap();
            for (int i = 0; i < N; ++i) {
                char[] L = A[i].toCharArray();
                for (int j0 = 0; j0 < L.length; ++j0)
                    for (int j1 = j0 + 1; j1 < L.length; ++j1) {
                        swap(L, j0, j1);
                        StringBuilder sb = new StringBuilder();
                        for (char c: L) sb.append(c);
                        buckets.computeIfAbsent(sb.toString(),
                                x-> new ArrayList<Integer>()).add(i);
                        swap(L, j0, j1);
                    }
            }
            for (int i1 = 0; i1 < A.length; ++i1)
                if (buckets.containsKey(A[i1]))
                    for (int i2: buckets.get(A[i1]))
                        dsu.union(i1, i2);
        }
        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (dsu.parent[i] == i) ans++;
        return ans;
        }
    }
}