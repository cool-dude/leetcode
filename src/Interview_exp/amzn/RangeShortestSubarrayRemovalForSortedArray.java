/*Find the range of shortest subarray which when
removed will make the remaining elements in the array sorted?
Ex:
[1, 2, 3, 99, 4, 2, 3, 5]
Ans: [3, 5] - { 99, 4, 2 } which when removed will make array { 1, 2, 3, 3, 5} which is sorted.

ii) [1, 2, 3, 4 , 5]
Ans: []

iii) [5, 4, 3, 2 ,1]
Ans: [0, 3]
But, [1, 4] is also a valid answer.*/
class Sln{
    public int shortestUnsortedContSeq(int[] arr){
        if(arr.length<=1)
            return 0;
        int last=arr.length-1;
        while (last>0 && arr[last-1]<=arr[last])
            last--;
        int ans=last;
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]<arr[i-1]) break;

            for(;last<arr.length && (last<=i||arr[last]<arr[i]);last++);

            ans=Math.min(ans,last-i-1);
        }
        return ans;
    }
}