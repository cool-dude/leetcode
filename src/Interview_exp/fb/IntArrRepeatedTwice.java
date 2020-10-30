/*
* Given an integer 'n',
* create an array such that each value is repeated twice. For example

n = 3 --> [1,1,2,2,3,3]
n = 4 --> [1,1,2,2,3,3,4,4]

After creating it, find a permutation such that each number is spaced in such a way, they are at a "their value" distance from the second occurrence of the same number.

For example: n = 3 --> This is the array - [1,1,2,2,3,3]

Your output should be [3,1,2,1,3,2]

The second 3 is 3 digits away from the first 3.
The second 2 is 2 digits away from the first 2.
The second 1 is 1 digit away from the first 1.

Return any 1 permutation if it exists. Empty array if no permutation exists.
Follow up: Return all possible permutations.*/
// "static void main" must be defined in a public class.
class Sln {
    public static int[] generate(int n) {
        int[] output = new int[2*n];
        int k=0;
        for (int i=1; i<=n; ++i) {
            output[k++] = i;
            output[k++] = i;
        }
        return output;
    }
    public static void permute(int[] A, List<List<Integer>> output) {
        int[] B = new int[A.length];
        int n = B.length/2;
        helper(B, n, 1, output);
    }
    public static void helper(int[] B, int n, int i, List<List<Integer>> output) {
        if (i==(n+1)) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int k=0; k<B.length; ++k) {
                arr.add(B[k]);
            }
            output.add(arr);
            return;
        }
        for (int k=0; (k+i+1)<B.length; ++k) {
            if (B[k] == 0 && B[k+i+1] == 0) {
                B[k] = i;
                B[k+i+1] = i;
                helper(B, n, i+1, output);
                B[k] = 0;
                B[k+i+1] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] A = generate(4);
        System.out.println(Arrays.toString(A));
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        permute(A, output);
        for (int k=0; k<output.size(); ++k) {
            for (int j=0; j<output.get(k).size(); ++j) {
                System.out.print(output.get(k).get(j) + " ");
            }
            System.out.println();
        }
    }
}






class Sln{
    public static int[] generate(int n){
        int[] arr=new int[2*n];
        int val=1;
        for(int i=0;i<2*n;i+=2){
            arr[i]=val;
            arr[i+1]=val++;
        }
        return arr;
    }
    public void helper(int[] nums, int n,int idx, List<List<Integer>> output){
        if(idx==(n+1)){
            List<Integer> res=new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                res.add(nums[i]);
            }
            output.add(res);
            return;
        }
        for(int i=0;(i+idx+1)<nums.length;i++){
            if((nums[i]==nums[i+idx+1]==0)||(nums[i]!=nums[i+idx+1]){
                nums[i]=idx;
                nums[i+idx+1]=idx;
                helper(nums,n,idx+1,output);
                nums[i]=0;
                nums[i+idx+1]=0;
            }
        }
    }
    public void permute(int[] nums, List<List<Integer>> output){
        int n=nums.length/2;
        helper(nums,n,1,output);
    }
    public static void main(String[] args) {
        int[] A = generate(4);
        System.out.println(Arrays.toString(A));
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        permute(A, output);
        for (int k=0; k<output.size(); ++k) {
            for (int j=0; j<4; ++j) {
                System.out.print(output.get(k).get(j) + " ");
            }
            System.out.println();
        }
    }
}


class Sln{
    public void helper(List<Integer> op, int idx,int n) {
        if(idx>n){
            print(op);
            return;
        }
        for(int i=0;(i+idx+1)<2*n;i++){
            if(op.get(i)==op.get(i+idx+1)==-1){
                op.set(i,idx);
                op.set(i+idx+1,idx);
                helper(op,idx+1,n);
                op.set(i,-1);
                op.set(i+idx+1,-1);
            }
        }
    }
    public void allCombinations(int n){
        List<Integer> op=new ArrayList<Integer>();
        for(int i=0;i<2*n;i++){
            op.add(-1);
        }
        helper(op, 1, n);
    }
    // Driver method
    public static void main(String[] args) {
        // given number
        int n = 3;
        allCombinations(n);
    }
}