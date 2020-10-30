import java.io.*;
import java.util.*;
class LongConsSub{
    static int findLongConSub(int a[],int n){
        HashSet<Integer> h=new HashSet<Integer>();
        int ans=0;

        for(int i=0;i<n;i++)
            h.add(a[i]);

        for(int i=0;i<n;i++){
            if(!h.contains(a[i]-1)){
                int j=a[i];
                while(h.contains(j))
                    j++;
                if(ans<j-a[i])
                    ans=j-a[i];
            }
        }
        return ans;
    }
}
//Hash insert and search takes O(1)
//T:O(n).