/*Given unsorted array, find how many elements can be found using binary search
- ex : [5,4,6,2,8] -> Ans : 3 -> '6' and '8' and '5' can be found using binary search*/
class Sln{
    int helper(int[] arr,int left,int right, int min,int max){
        if(right<left)
            return 0;
        else if(right==left)
            return (arr[left]>=min && arr[left]<=max?1:0);
        else {
            int mid=left+(right-left)/2;
            int count = (arr[mid]>=min && arr[mid]<=max?1:0);
            count += helper(arr, left, mid-1, min, Math.min(arr[mid], max));
            count += helper(arr, mid+1, right, Math.max(min, arr[mid]), max);
        }
        return count;
    }
    public int countPossibleMatches(int[] arr){
        return helper(arr,0,arr.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}