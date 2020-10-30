/*LC73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0,
set its entire row and column to 0. Do it in-place.
Example 1:
Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:
Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
* */
class Sln{
    public void setZeroes(int[][] mat){
        Boolean is1stCol=false;
        int R = mat.length;
        int C = mat[0].length;
        for(int i=0;i<R;i++){
            //1st columnn
            for(mat[i][0]==0){
                is1stCol=true;
            }
            for(int j=1;j<C;j++){
                if(mat[i][j]==0){
                    mat[i][0]=0;
                    mat[0][j]=0;
                }
            }
        }
        //iterate over array
        for(int i=1;i<R;i++){
            for(int j=1;j<C;j++){
                if(mat[i][0]==0||mat[0][j]==0){
                    mat[i][j]=0;
                }
            }
        }
        //check 1st row needs to be set
        if(mat[0][0]==0){
            for(int j=0;j<C;j++){
                mat[0][j]=0;
            }
        }
        if(is1stCol){
            //set 1st col zero
            for(int i=0;i<R;i++){
                mat[i][0]=0;
            }
        }
    }
}