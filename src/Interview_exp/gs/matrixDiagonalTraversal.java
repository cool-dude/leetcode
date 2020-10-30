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
*/
/*
* ALGO:
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
    public int[] iagonalOrder(int[][] arr){
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
                    r+=(c==N-1?1:0);
                    c+=(c<N-1?1:0);
                }
                else {
                    r+=(r<M-1?1::0);
                    c+=(r==M-1?1:0);
                }
            }
        }
        return result;
    }
}

