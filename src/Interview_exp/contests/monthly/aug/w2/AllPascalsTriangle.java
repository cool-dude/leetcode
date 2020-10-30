/*LC118: Pascal's Triangle
https://leetcode.com/problems/pascals-triangle/
Given a non-negative integer numRows,
generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is
the sum of the two numbers directly above it.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
class Sln1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }
        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            // The first row element is always 1.
            row.add(1);
            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            // The last row element is always 1.
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
/*LC119: Pascal's Triangle II
https://leetcode.com/problems/pascals-triangle-ii/
Given a non-negative index k where k ≤ 33,
return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.
In Pascal's triangle, each number is the
sum of the two numbers directly above it.

Example:
Input: 3
Output: [1,3,3,1]*/
class Sln2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<Integer>();
        res.add(1);
        for(int i=1;i<rowIndex+1;i++) {
            for (int j = i - 1; j >= 1; j--) {
                int tmp = res.get(j - 1) + res.get(j);
                res.set(j, tmp);
            }
            res.add(1);
        }
        return res;
    }
}