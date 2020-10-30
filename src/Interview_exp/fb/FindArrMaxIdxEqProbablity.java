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

    int rand(int num){
        if(num>Integer.MAX_VALUE){
            throw new IllegalArgumentException("Invalid Rage");
        }
        return new Random().nextInt(num)+1;
    }
    public int findRandomMinIdx(int arr[]){
        if(arr.length==0) return -1;
        if(arr.length==1) return 1;
        int min=Integer.MAX_VALUE, minCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
                minCount=1;
            }
            else if(min==arr[i]){
                minCount++;
            }
        }
        //return int b/w 1 and minCount
        int r=rand(minCount);
    }
    //T:O(N).
    //S:O(1).
}