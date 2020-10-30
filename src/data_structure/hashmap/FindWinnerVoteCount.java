// String findWinner(List<String> votes)
// Arrays.asList("A", "B", "A", "C", "D", "B", "A", "B");    t=n-1
import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args){
        //Solution s=new Solution();
        String winner=findWinner(Arrays.asList("A","B", "B", "B","A", "C", "D", "B", "A", "B"));
        if(winner==null)
            System.out.println("Election tie");
        else {
            System.out.println("Election winner: "+winner);
        }
    }
    static String findWinner(List<String> votes){
        if(votes==null||votes.size()==0) return "";
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(String vote:votes){
            map.put(vote,map.getOrDefault(vote, 0)+1);
        }
        int maxVote=0;
        String winner="";
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String k=e.getKey();
            int vote=e.getValue();
            if(maxVote<e.getValue()){
                maxVote=e.getValue();
                winner=k;
            }
            else if(vote==maxVote){
                winner=null;
            }
        }
        return winner;
    }
    //T:O
}