/*Given a 3 x n board, find the number of ways to fill it with 2 x 1 dominoes.*/
class Soln{
    int countWays(int n){
        int[] A=new int[n];
        int[] B=new int[n];
        A[0]==1;A[1]=0;
        B[0]=0;B[1]=1;
        for(int i=2;i<=n;i++){
            A[n]=A[n-2]+2*B[n-1];
            B[n]=A[n-1]+B[n-2];
        }
        return A[n];
    }
    // Driver code
    public static void main (String[] args) {
        int n = 8;
        System.out.println(countWays(n));
    }
}