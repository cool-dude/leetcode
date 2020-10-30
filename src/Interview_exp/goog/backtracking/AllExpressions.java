import java.awt.List;
import java.io.*;
import java.util.ArrayList;
// 3618 -> adding (*/+- =) -> [3*6=18, 3+6-1=8, ...]
//3,6,1,8  ->
// 2222 -> 2+2=2+2, 2*2=2+2, 2*2=2*2 ...
// 1818 -> 18=18, 1+8=1+8, ...
// Main class should be named 'Solution'
// 3618 -> 3[+-*/]6[+-*/]1[+-*/]8, 3*6+18, ..., 3*6+18 ... 36+18 ...
// 3 [+-*/] [618 -> (6+1+8, ...)]
class Sln{
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