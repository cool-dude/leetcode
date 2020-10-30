/*LC839: Similar String Groups
https://leetcode.com/problems/similar-string-groups/submissions/
Two strings X and Y are similar if we
can swap two letters (in different positions)
of X, so that it equals Y. Also two strings X
and Y are similar if they are equal.
For example, "tars" and "rats" are similar
(swapping at positions 0 and 2), and "rats"
and "arts" are similar, but "star" is not
similar to "tars", "rats", or "arts".
Together, these form two connected groups by similarity:
{"tars", "rats", "arts"} and {"star"}.
Notice that "tars" and "arts" are in the same group
even though they are not similar.  Formally, each
group is such that a word is in the group if and
only if it is similar to at least one other word
in the group.

We are given a list A of strings.  Every string in
A is an anagram of every other string in A.
How many groups are there?

Example 1:
Input: A = ["tars","rats","arts","star"]
Output: 2*/
class Sln {
    class UnionFind {
        int groups;
        int n;
        int[] parents;
        UnionFind(int n) {
            this.n=n;
            this.groups = n;
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        public int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                parents[xRoot] = yRoot;
                groups--;
            }
        }
    }
    public int numSimilarGroups(String[] A) {
        final int n = A.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.find(i) == uf.find(j)) continue;
                String str1 = A[i];
                String str2 = A[j];
                System.out.println(str1+"-"+str2);
                if (isSimilar(str1, str2)) uf.union(i, j);
            }
        }
        return uf.groups;
    }
    boolean isSimilar(String a, String b) {
        int count=0;
        for (int i = 0; i <a.length() ; i++) {
            if(a.charAt(i)!=b.charAt(i) && ++count>2) return false;
        }
        return true;
    }
}