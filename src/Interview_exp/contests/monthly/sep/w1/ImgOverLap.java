/*LC835: Image Overlap
https://leetcode.com/problems/image-overlap/
You are given two images img1 and img2
both of size n x n, represented as binary,
square matrices of the same size. (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose
(sliding it left, right, up, or down any number of units),
and place it on top of the other image.
After, the overlap of this translation
is the number of positions that have a 1 in both images.
(Note also that a translation does not include any kind of rotation.)
What is the largest possible overlap?

Example 1:
Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We slide img1 to right by 1 unit and down by 1 unit.
The number of positions that have a 1 in both images is 3. (Shown in red)

Example 2:
Input: img1 = [[1]], img2 = [[1]]
Output: 1

Example 3:
Input: img1 = [[0]], img2 = [[0]]
Output: 0
Constraints:
n == img1.length
n == img1[i].length
n == img2.length
n == img2[i].length
1 <= n <= 30
img1[i][j] is 0 or 1.
img2[i][j] is 0 or 1.
Assume index in A and B is [0, N * N -1].
Loop on A, if value == 1, save a coordinates i / N * 100 + i % N to LA.
Loop on B, if value == 1, save a coordinates i / N * 100 + i % N to LB.
Loop on combination (i, j) of LA and LB, increase count[i - j] by 1.
If we slide to make A[i] orverlap B[j], we can get 1 point.
Loop on count and return max values.
I use a 1 key hashmap. Assume ab for row and cd for col, I make it abcd as coordinate.
For sure, hashmap with 2 keys will be better for understanding.*/
class Sln {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        List<Integer> la=new ArrayList<>(),lb=new ArrayList<>();
        Map<Integer,Integer> count=new HashMap<>();
        Map<Integer,Integer> c=new HashMap<>();
        for(int i=0;i<n*n;i++)
            if(img1[i/n][i%n]==1)
                la.add(i/n*100+i%n);
        for(int i=0;i<n*n;i++)
            if(img1[i/n][i%n]==1)
                la.add(i/n*100+i%n);
         for(int i:la) for(int j:lb)
             count.put(i-j,count.getOrDefault(i-j,0)+1);
         int res=0;
         for(int i:count.values())
             res=Math.max(res,i);
         return res;
    }
}