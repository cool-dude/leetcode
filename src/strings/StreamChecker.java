/**Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);*/
class StreamChecker{
    class TrieNode{
        TrieNode[] children= new TrieNode[26];
        boolean isWord=false;
    }
    TrieNode root= new TrieNode();
    // int maxLen=0;
    // if the steam is too big and
    // can't be read into memory, then this limitation is needed
    StringBuilder sb= new StringBuilder();
    public StreamChecker(String[] words) {
        for(String w:words){
            TrieNode cur=root;
            for(int j=w.length()-1;j>=0;j--){
                int i=w.charAt(j)-'a';
                if(cur.children[i]==null) cur.children[i]=new TrieNode();
                cur=cur.children[i];
            }
            cur.isWord=true;
        }
    }
    public boolean query(char c){
        sb.append(c);
        TrieNode cur=root;
        for(int i=sb.length()-1;i>=0;i--){
            int j=sb.charAt(i)-'a';
            if(cur.children[j]==null) return false;
            cur=cur.children[j];
            if(cur.isWord) return true;
        }
        return false;
    }
}