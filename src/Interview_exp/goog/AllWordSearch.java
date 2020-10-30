/*LC79: Word Search
https://leetcode.com/problems/word-search/
Given a 2D board and a word,
find if the word exists in the grid.
The word can be constructed from letters
of sequentially adjacent cell, where
"adjacent" cells are those horizontally
or vertically neighboring. The same
letter cell may not be used more than once.
Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
Constraints:
board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3*/
class Sln1 {
    private char[][] board;
    private int ROWS;
    private int COLS;
    boolean backtrack(int row, int col, String word, int idx) {
        /* Step 1). check the bottom case. */
        if (idx >= word.length())
            return true;
        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(idx))
            return false;
        /* Step 3). explore the neighbors in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        this.board[row][col] = '#';

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir:dirs){
            ret=backtrack(row+dir[0],col+dir[1],word,idx+1);
            if(ret)
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
        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;
    }
}
/*LC212: Word Search II
https://leetcode.com/problems/word-search-ii/
Given a 2D board and a list of words
from the dictionary, find all words in the board.
Each word must be constructed from letters
of sequentially adjacent cell, where "adjacent"
cells are those horizontally or vertically
neighboring. The same letter cell may not
be used more than once in a word.
Example:
Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]*/
class Sln{
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    class TrieNode{
        TrieNode[] next;
        TrieNode(){
            next=new TrieNode[26];
        }
        String word;
    }
    void dfs(char[][] board,int i,int j,TrieNode p,List<String> result){
        if(i<0||i>=board.length||j<board[0].length||j>=board[0].length) return;
        char c=board[i][j];
        if(c=='#'||p.next[c-'a']==null) return;
        p=p.next[c-'a'];
        if(p.word!=null){
            result.add(p.word);
            p.word=null;
        }
        board[i][j]='#';
        for(int[] d:dir)
            dfs(board,i+d[0], j+d[1], p, result);
    }
    TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode cur=root;
            for(char c:word.toCharArray()){
                int i=c-'a';
                if(cur.next[i]==null) cur.next[i]=new TrieNode();
                cur=cur.next[i];
            }
            root.word=word;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words){
        List<String> result=new ArrayList<>();
        TrieNode root=buildTrie(words);
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                dfs(board,i,j,root,result);
    }
}