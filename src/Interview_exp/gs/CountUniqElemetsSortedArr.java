class Sln{
    public int countDistinct(int[] arr){
        //assume array sorted
        int n=arr.length;
        int res=0;
        for(int i=0;i<n;i++){
            while (i<n-1 && arr[i]==arr[i+1])
                i++;
            res++;
        }
        return res;
    }
    //T:O(n)
}