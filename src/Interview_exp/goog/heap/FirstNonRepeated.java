/*package whatever*/
import java.util.*;
import java.lang.*;
import java.io.*;
class Sln{
    final static int MAX=256;
    public static void main(String[] args){
        Scanner sc=new Scanner(system.in);
        int t=Integer.parseInt(sc.nextLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(sc.nextLine());
            List<Character> inDLL=new ArrayList<Character>();
            boolean[] repeated=new boolean[MAX];
            char[] a = sc.nextLine().replaceAll(" ","").toCharArray();
            //number of elements
            for(int j=0;j<n;j++){
                if(!repeated[a[j]]){
                    if(!inDLL.contains(a[j])) {
                        inDLL.add(a[j]);
                    }
                    else{
                        inDLL.remove(a[j]);
                        repeated[a[j]]=true;
                    }
                }
                if(inDLL.size()!=0)
                    System.out.print(inDLL.get(0)+" ");
                else
                    System.out.print("-1");
            }
            System.out.println();
        }
    }
}