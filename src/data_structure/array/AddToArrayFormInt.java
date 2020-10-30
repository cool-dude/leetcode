/*LC989: Add to Array-Form of Integer
https://leetcode.com/articles/add-to-array-form-of-integer/
For a non-negative integer X, the array-form
of X is an array of its digits in
left to right order.
If X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative
integer X, return the array-form of the integer X+K.*/
class Sln{
    public List<Integer> addToArrayForm(int[] A,int K){
        int N = A.length;
        int cur = K;
        List<Integer> ans=new ArrayList();
        int i=N;
        while (--i>=0||cur>0){
            if(i>=0){
                cur += A[i];
            }
            ans.add(cur%10);
            cur/=10;
        }
        Collections.reverse(ans);
        return ans;
    }
    //T:O(N).
    //S:O(1).
}