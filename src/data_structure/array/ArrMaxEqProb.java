class Sln{
    int rand(int maxCount){
        //out of range
        if(maxCount>Integer.MAX_VALUE){
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(maxCount)+1;
    }
    public int findRandomMaxIdx(int arr[]){
        int max=Integer.MIN_VALUE, maxCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                maxCount=1;
            }
            else if(max==arr[i]){
                maxCount++;
            }
        }
        //return int b/w 1 and maxCount
        int r=rand(maxCount);
        for(int i=0,c=0;i<arr.length;i++){
            if(arr[i]==max){
                c++;
            }
            if(c==r){
                return i;
            }
        }
    }
    //T:O(N).
    //S:O(1).
}