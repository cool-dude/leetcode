/*Suppose we have some input data describing a
graph of relationships between parents and children
over multiple generations. The data is formatted
as a list of (parent, child) pairs, where each
individual is assigned a unique integer identifier.
For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.
         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11
parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
]
Write a function that takes the graph, as well as
two of the individuals in our dataset, as its
inputs and returns true if and only if they share at least one ancestor.
Sample input and output:
hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true
Additional example: In this diagram, 4 and 12 have a common ancestor of 11.
        11
       /  \
      10   12
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8
parentChildPairs2 = [
    (11, 10), (11, 12), (2, 3), (10, 2), (10, 5),
    (1, 3), (3, 4), (5, 6), (5, 7), (7, 8),
]
hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false
n: number of pairs in the input*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] argv) {
        int[][] parentChildPairs1 = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
        };

        int[][] parentChildPairs2 = new int[][] {
                {11, 10}, {11, 12}, {2, 3}, {10, 2}, {10, 5},
                {1, 3}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };
        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8));
    /*
    List<List<Integer>> res=findNodesWithZeroAndOneParents(parentChildPairs);
    for(List<Integer> lst:res){
      for(int l:lst){
        System.out.print(l+" ");
      }
      System.out.println();
    }
    */
    }
    public static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] A){
        Map<Integer,Integer> numParentsMap = new HashMap<>();
        for(int[] num:A){
            int par=num[0];
            int child=num[1];
            numParentsMap.put(child,numParentsMap.getOrDefault(child,0)+1);
            if(!numParentsMap.containsKey(par))
                numParentsMap.put(par,0);
        }
        List<Integer> zp=new ArrayList<>();
        List<Integer> op=new ArrayList<>();
        for(int k:numParentsMap.keySet()){
            if(numParentsMap.get(k)==0)
                zp.add(k);
            else if(numParentsMap.get(k)==1)
                op.add(k);
        }
        List<List<Integer>> res=new ArrayList<>();
        res.add(zp);res.add(op);
        return res;
    }
    //T:O(n)
    //S:O(n)

    public static boolean hasCommonAncestor(int[][] A,int x,int y){
        Map<Integer,Set<Integer>> ancestorMap=new HashMap<>();
        for(int[] num:A){
            int par=num[0];
            int child=num[1];
            Set<Integer> pars=ancestorMap.getOrDefault(child,new HashSet<>());
            pars.add(par);
            ancestorMap.put(child,pars);
            if(!ancestorMap.containsKey(par)){
                ancestorMap.put(par,new HashSet<>());
                continue;
            }
            ancestorMap.get(child).addAll(ancestorMap.get(par));
        }
        Set<Integer> s1=ancestorMap.get(x),s2=ancestorMap.get(y);
        s1.retainAll(s2);
        if(s1.size()>0) return true;
        else return false;
    }
}