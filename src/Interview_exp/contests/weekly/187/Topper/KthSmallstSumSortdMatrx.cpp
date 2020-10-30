    /*LC1439: Find the Kth Smallest Sum of a Matrix With Sorted Rows
https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
You are given an m * n matrix, mat,
and an integer k, which has its rows
sorted in non-decreasing order.
You are allowed to choose exactly 1
element from each row to form an array. Return the Kth smallest array sum among all possible arrays.

Example 1:
Input: mat = [[1,3,11],[2,4,6]], k = 5
Output: 7
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.

Example 2:
Input: mat = [[1,3,11],[2,4,6]], k = 9
Output: 17

Example 3:
Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
Output: 9
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.*/
class Solution {
    public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        int n = mat.size(), m = mat[0].size();
        set<pair<int, vector<int>>> mp;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += mat[i][0];
        mp.insert(make_pair(sum, vector<int>(n, 0)));
        vector<int> all;
        while(all.size() < k){
            auto [v, ind] = *mp.begin(); mp.erase(mp.begin());
            all.push_back(v);
            for(int i = 0; i < n; i++){
                if(ind[i] + 1 < m){
                    vector<int> cp = ind;
                    cp[i]++;
                    mp.insert(make_pair(v - mat[i][ind[i]] + mat[i][ind[i] + 1], cp));
                }
            }
        }
        return all[k - 1];
    }
};