/*LC79: Word Search
Given a 2D board and a word,
* find if the word exists in the grid.

The word can be constructed from letters of
sequentially adjacent cell, where "adjacent"
* cells are those horizontally or vertically neighboring.
* The same letter cell may not be used more than once.
Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.*/
class Sln {
    private char[][] board;
    private int ROWS;
    private int COLS;
    boolean backtrack(int row, int col, String word, int idx) {
        /* Step 1). check the bottom case. */
        if (idx >= word.length())
            return true;
        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(idx)) {
            return false;
        }
        /* Step 3). explore the neighbors in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, idx + 1);
            if (ret)
                break;
        }
        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(idx);
        return ret;
    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        for (int row = 0; row < this.ROWS; row++)
            for (int col = 0; col < this.COLS; col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;
    }
}