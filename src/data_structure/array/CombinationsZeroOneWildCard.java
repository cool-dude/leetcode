package coderbyte;
import java.util.*;
import java.util.Arrays;
class Sln{
    private static void print(char[] sArr, int idx){
        if(idx==sArr.length){
            System.out.println(sArr);
            return;
        }
        if(sArr[idx]=='?'){
            sArr[idx]='0';
            print(sArr, idx+1);
            sArr[idx]='1';
            print(sArr, idx+1);
        }
    }
    public void generateAllPattern(String str){
        if(str==null)
            return;
        char[] sArr=str.toCharArray();
        print(sArr, 0);
    }
    //T:O(2^n).
    //S:O(1).
}