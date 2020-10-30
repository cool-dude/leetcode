package practice.backtracking;
/*LC51: N-Queens
https://leetcode.com/problems/n-queens/
* The n-queens puzzle is the problem of placing n queens
* on an n×n chessboard such that no two queens attack each other.*/
import java.util.ArrayList;
import java.util.List;
public class NQueens{
    private static int count=0;
    public boolean isValid(List<char[]>curr,int row,int col,int n) {
        //for same column
        for(int i=0;i<row;i++) {
            if(curr.get(i)[col]=='Q')
                return false;
        }
        //for diagonal at 45 degree
        for(int i=row-1,j=col-1;i>=0&&j>=0 ;i--,j--) {
            if(curr.get(i)[j]=='Q')
                return false;
        }
        //for diagonal at 135 degree
        for(int i=row-1,j=col+1;i>=0&&j<n ;i--,j++) {
            if(curr.get(i)[j]=='Q')
                return false;
        }
        return true;
    }
    public void dfs(List<List<String>>res,List<char[]>curr,int row,int n) {
        if(row==n) {
            List<String>temp=new ArrayList();
            for(int i=0;i<curr.size();i++) {
                char[] now=curr.get(i);
                String tem=new String(now);
                temp.add(tem);
            }
            res.add(temp);
            return;
        }
        for(int col=0;col<n;col++) {
            if(isValid(curr,row,col,n)) {
                curr.get(row)[col]='Q';
                dfs(res,curr,row+1,n);
                curr.get(row)[col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<char[]> curr=new ArrayList<>();
        for(int i=0;i<n;i++) {
            char[] arr=new char[n];
            Arrays.fill(arr,'.');
            curr.add(arr);
        }
        dfs(res,curr,0,n);
        return res;
    }
}

class Sln{
    final static int N = 4;
    boolean isSafe(int[][] board,int row,int col){
        //row on left
        for(int i=0;i<col;i++){
            if(board[row][i]){
                return false;
            }
        }
        //col on top
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        //col upper-diagonal
        for(int i=row,int j=col;i>=0,j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        //col lower-diagonal
        for(int i=row,int j=col;i<N,j>=0;i++,j--){
            if(board[i][j]){
                return false;
            }
        }
    }
    boolean solveNQUtil(int[][] board, int col){
        if(col>=N){
            return true;
        }
        for (int row = 0; row < N; row++) {
            if(isSafe(board,row,col)){
                board[row][col]=1;
                if(solveNQUtil(board,col+1)) return true;
                board[row][col]=0;
            }
        }
        return false;
    }
    public boolean solveNQ() {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution not exist");
            return false;
        }
        printSolution(board);
        return true;
    }
    public static void main(String[] args) {
        Nqueens Queen = new Nqueens();
        Queen.solveNQ();
    }
    //T:O(2^n).
}