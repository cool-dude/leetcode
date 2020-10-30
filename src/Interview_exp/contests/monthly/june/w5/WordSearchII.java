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