class Graph{
    private final int V;
    private final LinkedList<Integer>[] adjList;
    Graph(int v_){
        V=v_;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++)
            adjList[i] = new LinkedList<>();
    }
    void addEdge(int start,int end){
        adjList[start].add(end);
    }
    int getNumVerts(){
        return V;
    }
    void helper(int curVertex,boolean[] visited,
                      Stack<Integer> st){
        visited[curVertex] = true;
        for(int adjVertex:adjList[curVertex]){
            if(!visited[adjVertex]){
                helper(adjVertex, visited, st);
            }
        }
        st.push(new Integer(curVertex));
    }
    String topoSort(){
        String result="";
        Stack<Integer> st=new Stack<Integer>();
        boolean[] visited=new boolean[getNumVerts()];
        //mark all vertices as not visited
        for(int i=0;i<getNumVerts();i++)
            visited[i]=false;
        //call recursive helper function
        for(int i=0;i<getNumVerts();i++){
            if(!visited[i])
                helper(i,visited,st);
        }
        //print contents of stack
        while(!st.isEmpty())
            result+=(char)('a'+st.pop());
        return result;
    }
    public String alienOrder(String[] words) {
        //Create graph with 'alpha' edges
        Set<Character> set=new HashSet<Character>();
        for(String word:words){
            for(int i=0;i<word.length();i++){
                set.add(word.charAt(i));
            }
        }
        Graph g=new Graph(set.size());
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                // If we find mismatch character, then add edge
                // from character of word1 to word2.
                if(word1.charAt(j)!=word2.charAt(j)){
                    g.addEdge(word1.charAt(j)-'a',word2.charAt(j)-'a');
                    break;
                }
            }
        }
        return g.topoSort();
    }
}