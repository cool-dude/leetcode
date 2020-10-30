/*LC498: Diagonal Traverse
Given a matrix of M x N elements
(M rows, N columns),
return all elements of the matrix
in diagonal order as shown in the below image.

Example:
Input:
[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
ALGO:
* tail = [i, j]
if direction == up, then {
   if [i, j + 1] is within bounds, then {
       next_head = [i, j + 1]
   } else {
       next_head = [i + 1, j]
   }
} else {
   if [i + 1, j] is within bounds, then {
       next_head = [i + 1, j]
   } else {
       next_head = [i, j + 1]
   }
}*/
class Sln{
    boolean isValid(int x,int y,int m,int n) {
        if (x < 0 || x >= m || y < 0 || y >= n)
            return false;
        return true;
    }
    public int[] diagonalOrder(int[][] arr){
        if(arr==null||arr.length==0){
            return new int[0];
        }
        int m=arr.length;
        int n=arr[0].length;
        int r=0,c=0;
        int dir=1;
        int[] result=new int[m*n];
        int idx=0;
        while (r<m && c<n){
            result[idx++]=arr[r][c];
            int new_row=r+(dir==1?-1:1);
            int new_col=c+(dir==1?1:-1);
            // Checking if next element in diagonal
            // within bounds of matrix.
            // If it's not within the bounds,
            // we have to find the next head.
            if(isValid(new_row,new_col,m,n)){
                r=new_row;
                c=new_col;
            }
            else {
                // If the current diagonal
                // was going in the upwards
                // direction.
                if(dir==1){
                    //if col boundary reached
                    r+=(c==n-1?1:0);
                    c+=(c<n-1?1:0);
                }
                else {
                    r+=(r<m-1?1::0);
                    c+=(r==m-1?1:0);
                }
                dir=-dir;
            }
        }
        return result;
    }
}
/*LC1424: Diagonal Traverse II
https://leetcode.com/problems/diagonal-traverse-ii/
Given a list of lists of integers, nums,
return all elements of nums in diagonal order as shown in the below images.

Example 1:
Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Example 2:
Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

Example 3:
Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]*/
class Sln2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0, i = 0, maxKey = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int r = nums.size() - 1; r >= 0; --r) { // The values from the bottom rows are the starting values of the diagonals.
            for (int c = 0; c < nums.get(r).size(); ++c) {
                map.putIfAbsent(r + c, new ArrayList<>());
                map.get(r + c).add(nums.get(r).get(c));
                maxKey = Math.max(maxKey, r + c);
                n++;
            }
        }
        int[] ans = new int[n];
        for (int key = 0; key <= maxKey; ++key) {
            List<Integer> value = map.get(key);
            if (value == null) continue;
            for (int v : value) ans[i++] = v;
        }
        return ans;
    }
}