class AutoComplete{
    private int SIZE=26;
    class TNode{
        String prefix;
        TNode children[SIZE];
        boolean isWord;
        public TNode(String s){
            prefix=s;
            children=new TNode[SIZE];
            isWord=false;
        }
    }
    void insert(TNode root, String word){
        if(word==null||word.length()==0)
            return;
        TNode pCrawl=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(pCrawl.children[c-'a']==null)
                pCrawl.children[c-'a']=new TNode(word.substring(0,i+1));
            pCrawl=pCrawl.children[c-'a'];
            if(i==word.length()-1) pCrawl.isWord=true;
        }
    }
    public List<String> findAllWords(TNode root,String word){
        List<String> results=new ArrayList<>();
        TNode pCrawl=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(pCrawl.children[c-'a']!=null)
                pCrawl=pCrawl.children[c-'a'];
            else
                return results;
        }
        findAllChildren(pCrawl,results);
        return results;
    }
    void findAllChildren(TNode node, List<String> results){
        if(node.isWord) results.add(node.prefix);
        for(int i=0;i<26;i++) {
            if (root.children[i] != null)
                findAllChildren(node.children[i], results);
        }
    }
    public static void main(String[] args) {
        AutoComplete ac = new AutoComplete();
        String[] words = new String[]{"cat", "ca", "dog", "cats"};
        for (String w : words) {
            ac.insert(w);
        }
        System.out.println(ac.findAllTheWords("ca"));
    }
}