/*2 Arrays subsequence of each other
A of N integers is subsequence of B of M integers*
by adding min eleements to B.*/
class Sln{
    int min_num_elements(int n,int[] A,int m,int[] B){
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(A[i],i);
        List<Integer> subseq;
        int l=0,r=-1;
        for(int i=0;i<m;i++){
            if(map.containsKey(B[i])){
                int e=map.get(B[i]);
                while (l<=r){
                    int mid=l+(r-l)/2;
                    if(subseq.get(mid)<e)
                        l=mid+1;
                    else
                        r=mid-1;
                }
                if(r<subseq.size()-1)
                    subseq.set(r+1,e);
                else
                    subseq.add(e);
                l=0,r=subseq.size()-1;
            }
        }
        return n-subseq.size();
    }
}