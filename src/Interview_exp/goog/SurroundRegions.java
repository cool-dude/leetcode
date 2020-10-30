/*LC130: Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O),
capture all regions surrounded by 'X'.
        Example:

        X X X X
        X O O X
        X X O X
        X O X X
        After running your function, the board should be:

        X X X X
        X X X X
        X X X X
        X O X X
        Explanation:
 Surrounded regions shouldn’t be on the border, which means
 that any 'O' on the border of the board are not flipped to 'X'.
 Any 'O' that is not on the border and it is not connected to an
 'O' on the border will be flipped to 'X'. Two cells are connected
if they are adjacent cells connected horizontally or vertically.*/
class Sln {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[m - 1][j] == 'O') helper(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O') return;
        board[r][c] = '*';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }
}


class Pair{
    public int first;
    public int second;
    public Pair(int f, int s){
        first=f;
        second=s;
    }
}
class Sln{
    private int R=0;
    private int C=0;
    void DFS(char[][] b,int r,int c){
        LinkedList<Pair<int, int>> q = new LinkedList<Pair<int, int>>();
        queue.offer(new Pair<>(r, c));

        while (!queue.isEmpty()) {
            // pop out the _tail_ element, rather than the head
            Pair<Integer, Integer> pair = queue.pollLast();
            int row = pair.first, col = pair.second;
            if (board[row][col] != 'O')
                continue;

            board[row][col] = 'E';
            if (col < this.COLS - 1)
                queue.offer(new Pair<>(row, col + 1));
            if (row < this.ROWS - 1)
                queue.offer(new Pair<>(row + 1, col));
            if (col > 0)
                queue.offer(new Pair<>(row, col - 1));
            if (row > 0)
                queue.offer(new Pair<>(row - 1, col));
    }
    public void solve(char[][] b){
        if(b==null||b.length==0){
            return;
        }
        R=b.length;
        C=b[0].length;
        List<Pair<int,int>> borders=new LinkedList<Pair<int,int>();
        //add column borders
        for(int r=0;r<R;r++){
            borders.add(new Pair(r,0));
            borders.add(new Pair(r,C-1));
        }
        for(int c=0; c<C;c++){
            borders.add(new Pair(0,c));
            borders.add(new Pair(R-1,c));
        }
        //DFS and mark
        for(Pair<int,int> pair:borders){
            DFS(b, pair.first, pair.second);
        }
    }
}