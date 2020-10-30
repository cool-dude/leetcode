import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
// 3618 -> adding (*/+- =) -> [3*6=18, 3+6-1=8, ...]
//3,6,1,8  ->
// 2222 -> 2+2=2+2, 2*2=2+2, 2*2=2*2 ...
// 1818 -> 18=18, 1+8=1+8, ...
// Main class should be named 'Solution'
// 3618 -> 3[+-*/]6[+-*/]1[+-*/]8, 3*6+18, ..., 3*6+18 ... 36+18 ...
// 3 [+-*/] [618 -> (6+1+8, ...)]
class Sln {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
    void backtrack(String prev,int start,List<String> res,List<Integer> nums){
        char[] signs=new char[]{'+','-','*','/'};
        if(start==nums.size()){
            return;
        }
        else{
            for(int i=start;i<nums.size()-1;i++){
                for(char c:signs){
                    res.add(Integer.toString(prev)+c+Integer.toString(nums.get(i+1)));
                    backtrack(res.get(res.size()-1),nums.get(start+1),start+1,res,nums);
                    res.remove(res.size()-1);
                }
            }
        }
    }
    public static List<String> getExpressions(List<Integer> nums){
        boolean[] used=new boolean[4];
        if(nums==null||nums.size()==0) return new ArrayList<String>();
        int i=0;
        List<String> res;
        int prev=0;
        for(int num:nums){
            backtrack(String.valueOf(num),0,res,nums);
        }
    }
}

class Sln2 {
    public static void helper(char[] ops, List<Integer> nums, int pos, String expr) {
        expr += nums.get(pos);
        if (pos == nums.size() - 1) {
                res.add(expr);
        }
        else {
            for (char op : ops) {
                helper(ops, nums, pos + 1, expr + op);
            }
        }
    }
    public static void allEqns(List<Integer> nums){
        char[] ops = {'+','-','*','/'};
        helper(ops, nums, 0, "");
    }
}

class Sln3{
    void helper(List<String> res,String cur, String ip,int target, int pos,int curVal,int last){
        if(pos==ip.length()){
            if(curVal==target)
                res.add(cur);
            return;
        }
        for(int i=pos;i<ip.length();i++){
            if(i!=pos && ip.charAt(pos)=='0')
                break;
            String part=ip.substring(pos,i+1);
            int cur=Integer.parseInt(part);
            if(pos==0)
                helper(res,cur+part,ip,target,i+1,cur,cur);
            else {
                helper(res,cur+"+",part,ip,target,i+1,curVal+cur,cur);
                helper(res,cur+"-",part,ip,target,i+1,curVal-cur,-cur);
                helper(res,cur+"*",part,ip,target,i+1,curVal-last + last*cur,last*cur);
                helper(res,cur+"/",part,ip,target,i+1,curVal-last + last/cur,last/cur);
                helper(res,cur+"",part,ip,target,i+1,curVal-last + last/cur,last/cur);
            }
        }
    }
    List<String> getEqns(String ip,int target){
        List<String> res;
        helper(res,"",ip,target,0,0,0);
    }
    int main(){
        String ip="3618";
        int target=0;
        List<String> res=getEqns(ip,target);
    }
}