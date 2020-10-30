package coderbyte;
import java.util.*;
import java.util.Arrays;
class Sln{
    private static Set allSets=new TreeSet();
    public static Set generateAllPatterns(String str){
        if(str==null)
            return;
        else if(!str.contains('?')){//Base case
            allSets.add(str);
            return allSets;
        }
        else{
            generateAllPatterns(str.replaceFirst("\\?","0"));
            generateAllPatterns(str.replaceFirst("\\?","1"));
        }
    }
    public static String genPatternQueue(String str){
        queue<String> qs;
        qs.push(str);
        while (!qs.isEmpty()){
            String s=q.front();
            int idx=s.indexOf('?');
            if(idx!=-1){
                StringBuilder sb1=new StringBuilder(s);
                qs.push(sb1.setCharAt(idx, '0').toString());
                StringBuilder sb2=new StringBuilder(s);
                qs.push(sb2.setCharAt(idx, '1').toString());
            }
            else{
                System.out.println(s)
            }
        }
    }
    public static void print(char[] sArr, int idx){
        if(idx==sArr.length){
            System.out.println(sArr);
            return;
        }
        if(sArr[idx]=='?'){
            sArr[idx]='0';
            print(sArr, idx+1 );
            sArr[idx]='1';
            print(sArr, idx+1);
        }
    }
    public static void generateAllPattern(String str){ if(str==null)
            return;
       char[] sArr=str.toCharArray();
       print(sArr, 0);
    }
}