/*Maximum consecutive one’s(or zeros) in binary array
Given binary array, find count of maximum number
* of consecutive 1’s present in the array.
Examples :
Input  : arr[] = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1}
Output : 4
Input  : arr[] = {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
Output : 1*/
class Sln1{
    public int getMaxLength(int[] arr){
        int count=0,result=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count=0;
            }
            else {
                count++;
                result=Math.max(result, count);
            }
        }
        return result;
    }
}
/*Maximum consecutive one’s(or zeros) in binary circular array
Given a binary circular array of size N, the task
* is to find the count maximum number of
* consecutive 1’s present in the circular array.
Examples:
Input: arr[] = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1}
Output: 6
The last 4 and first 2 positions have 6 consecutive ones.*/
class Sln2{
    public int getMaxLength(int[] arr){
        // prefix count array
        int start=0, prefixCnt=0;
        while (start<n && arr[start]==1){
            start++;
            prefixCnt++;
        }
        int end=n-1, suffixCnt=0;
        while (end>=0 && arr[end]==1){
            suffixCnt++;
            end--;
        }
        //all elements 1
        if(start>end)
            return n
        int midCnt=0, result=0;
        for(int i=start;i<end;i++){
            if(arr[i]==1){
                midCnt++;
                result = Math.max(result, midCnt);
            }
            else {
                midCnt = 0;
            }
        }
        return Math.max(result, preCnt+sufCnt);
    }
    //T:O(n).
    //S:O(1).
}