package pramp;

public class GettingMissingNumber {
    /**
     * 0 5 10
     * true false false
     * <p>
     * 0 2 3 4
     * <p>
     * true false true true true
     * <p>
     * false->1
     * <p>
     * boolean[] result=new boolean[];
     * <p>
     * Time: O(N)
     * Space: O(N)
     */
    static int getDifferentNumber(int[] arr) {
        // your code goes here
        // checking the wrong input case
        if (arr.length == 0)
            return -1;
        // helper to keep track the output
        boolean[] result = new boolean[arr.length];

        for (int j = 0; j < arr.length; j++) {
            int data = arr[j];
            if (data >= arr.length)
                continue;
            else// coninue ?
                result[data] = true; // j?
        }
        // finding the min value which is not found in the array.
        int i;
        for (i = 0; i < result.length; i++) {
            if (!result[i]) {
                return i;
            }
        }
        if (i == result.length)
            return i;
        return -1;
    }

    // curMiss=0;
    public static void main(String[] args) {
        int[] input = new int[]{0, 2, 3, 4};
        System.out.println(getDifferentNumber(input));
    }
}

/*
Given an arr of n unique non-negative integers,
how can you most efficiently find a non-negative
integer that is not in the array?
* */
class Soln{
    static int getDifferentNumber(int[] arr) {
        if(arr.length==0)
            return -1;
        boolean[] result=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            int d=arr[i];
            if(d>=arr.length)
                continue;
            else
                result[d]=true;
        }
        for(int i=0;i<result.length;i++){
            if(!result[i])
                return i;
        }
        if (i == result.length)
            return i;
        return -1;
    }
}