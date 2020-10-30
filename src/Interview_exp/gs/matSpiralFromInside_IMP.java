import java.io.*;
class Soln{
	static void printSpiral(int[][] m,
	int r,int c)
	{
		 for (i = low_column + 1; i <= high_column && 
                         i < c && low_row >= 0; ++i)
            System.out.print (mat[low_row][i] + " ");
        low_row -= 1;
 
        for (i = low_row + 2; i <= high_row && i < r && 
                                  high_column < c; ++i)
            System.out.print(mat[i][high_column] + " ");
        high_column += 1;
 
        for (i = high_column - 2; i >= low_column &&
                        i >= 0 && high_row < r; --i)
            System.out.print(mat[high_row][i] + " ");
        high_row += 1;
 
        for (i = high_row - 2; i > low_row && i >= 0
                            && low_column >= 0; --i)
            System.out.print(mat[i][low_column] +" ");
        low_column -= 1;
    }
    System.out.println();
	}
}