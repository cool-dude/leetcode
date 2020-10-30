/*
* 269. Alien Dictionary
* https://leetcode.com/problems/alien-dictionary/
There is a new alien language which uses
* the latin alphabet. However, the order
* among letters are unknown to you. You
* receive a list of non-empty words from
* the dictionary, where words are sorted
* lexicographically by the rules of this
* new language. Derive the order of letters in this language.
Example 1:
Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
*
Example 2:
Input:
[
  "z",
  "x"
]

Output: "zx"

* Example 3:
Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
* */
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
    void topoSortUtil(int curVertex,boolean[] visited,
                      Stack<Integer> st){
        visited[curVertex] = true;
        for(int adjVertex:adjList[curVertex]){
            if(!visited[adjVertex]){
                topoSortUtil(adjVertex, visited, st);
            }
        }
        st.push(new Integer(curVertex));
    }
    String topoSort(){
        String result="";
        Stack<Integer> st=new Stack<Integer>();
        boolean[] visited=new boolean[getNumVerts()];
        //mark all vertices as not visited
        for(int i=0;i<getNumVerts();i++){
            visited[i]=false;
        }
        //call recursive helper function
        for(int i=0;i<getNumVerts();i++){
            if(!visited[i])
                topoSortUtil(i,visited,st);
        }
        //print contents of stack
        while(!st.isEmpty())
            result+=(char)('a'+st.pop());
        return result;
    }
}

class Solution {
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

class Sln{
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);
        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }
    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int length = Math.min(first.length(), second.length());
            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }
    }
    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        int count=0;
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
                count++;
            }
        }
        if(count==graph.size()) return "";
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }
}