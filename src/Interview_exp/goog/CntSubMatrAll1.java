/*LC1504: Count Submatrices With All Ones
https://leetcode.com/problems/count-submatrices-with-all-ones/
Given a rows * columns matrix mat of ones
and zeros, return how many submatrices have all ones.
Example 1:
Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2.
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:
Input: mat = [[0,1,1,0],
              [0,1,1,1],
              [1,1,1,0]]
Output: 24
Explanation:
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3.
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2.
There are 2 rectangles of side 3x1.
There is 1 rectangle of side 3x2.
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
Example 3:
Input: mat = [[1,1,1,1,1,1]]
Output: 21
Example 4:
Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5
Now, Let's solve 2D metrics by finding all 1
submetrics from row "up" to row "down".
And apply above 1D helper function. Note:
the array h[k] == 1 means all values in
column k from row "up" to "down" are 1
(that's why we use &). So overall, the idea
is to "compress" the 2D array to the 1D array,
and apply 1D array method on it, while trying all heights up to down.*/
class Sln1{
    int countOneRow(int[] A){
        int res=0,l=0;
        for(int i=0;i<A.length;i++){
            l=(A[i]==0?0:l+1);
            res+=l;
        }
        return res;
    }
    public int numSubmat(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int res=0;
        for(int up=0;up<m;up++){
            int[] h=new int[n];
            Arryas.fill(h,1);
            for(int down=up;down<m;down++){
                for(int k=0;k<n;k++) h[k]&=mat[down][k];
                res+=countOneRow(h);
            }
        }
        return res;
    }
    //T:O(NMN)
}
/*O(M*N) by Using Stack
By using mono-stack, what we want to achieve is
to find the first previous index "preIndex",
whose number of continuous 1 is less than
current column index i. And the value of index
between preIndex and i are all equal or larger
than index i. So it can form a big sub-metrics.
Note: sum[i] means the number of submatrices
with the column "i" as the right border.

If stack is empty, meaning: all previous columns
has more/equal ones than current column. So,
the number of metrics can form is simply A[i] * (i + 1); (0-index)
If stack is not empty, meaning: there is a shorter
column which breaks our road. Now, the number of
metrics can form is sum[i] += A[i] * (i - preIndex).
And plus, we can form a longer submetrics with that
previou shorter column sum[preIndex].
The best way to understand is to draw a graph.*/
class Sln2{
    int helper(int[] A){
        int[] sum=new int[A.length];
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < A.length; ++i) {
            while (!s.isEmpty() && A[s.peek()] >= A[i]) s.pop();
            if (!s.isEmpty()) {
                int preIndex = s.peek();
                sum[i] = sum[preIndex];
                sum[i] += A[i] * (i - preIndex);
            }
            else {
                sum[i] = A[i] * (i + 1);
            }
            s.push(i);
        }
        int res = 0;
        for (int su : sum) res += su;
        return res;
    }
    public int numSubmat(int[][] mat){
        int m=mat.length,n=mat[0].length;
        int res=0;
        int[] h=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                h[j]=(mat[i][j]==0?0:h[j]+1);
            }
            res+=helper(h);
        }
        return res;
    }
    //T:O(MXN)
}