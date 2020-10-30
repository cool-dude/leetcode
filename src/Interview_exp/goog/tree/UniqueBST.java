/*LC96. Unique Binary Search Trees
https://leetcode.com/problems/unique-binary-search-trees/solution/
Given n, how many structurally unique BST's (
* binary search trees) that store values 1 ... n?
Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/
class Sln{
    public int numTrees(int n){
        int[] G=new int[n+1];
        G[0]=1;
        G[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=i;j<=i;j++){
                G[i]+=G[j]*G[n-j];
            }
        }
        return G[n];
    }
}