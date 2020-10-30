/*LC399: Evaluate Division
https://leetcode.com/problems/evaluate-division/
You are given an array of variable
pairs equations and an array of real
numbers values, where equations[i] = [Ai, Bi]
and values[i] represent the equation Ai / Bi = values[i].
Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where
queries[j] = [Cj, Dj] represents the jth
query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries.
If a single answer cannot be determined,
return -1.0.
Note: The input is always valid. You
may assume that evaluating the queries
will not result in division by zero
and that there is no contradiction.

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
Constraints:
1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.*/
class Sln {
    Map<String,Map<String,Double>> buildGraph(List<List<String>> eqns,double[] vals){
        Map<String,Map<String,Double>> g=new HashMap<>();
        String u,v;
        for(int i=0;i<eqns.size();i++){
            u=eqns.get(i).get(0);
            v=eqns.get(i).get(1);
            g.putIfAbsent(u,new HashMap<>());
            g.get(u).put(v,vals[i]);
            g.putIfAbsent(v,new HashMap<>());
            g.get(v).put(u,1/vals[i]);
        }
        return g;
    }
    double getPathWeight(String start,String end,Set<String> visited,Map<String,Map<String,Double>> g){
        if(!g.containsKey(start))
            return -1.0;
        if(g.get(start).containsKey(end))
            return g.get(start).get(end);
        visited.add(start);
        for(Map.Entry<String,Double> nbr:g.get(start).entrySet()){
            if(!visited.contains(nbr.getKey())){
                double wt=getPathWeight(nbr.getKey(),end,visited,g);
                if(wt!=-1.0)
                    return nbr.getValue()*wt;
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> g=buildGraph(equations,values);
        double[] res=new double[queries.size()];
        for(int i=0;i<queries.size();i++)
            res[i]=getPathWeight(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>(),g);
        return res;
    }
}