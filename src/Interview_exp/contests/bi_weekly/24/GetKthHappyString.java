/*
LC1415: The k-th Lexicographical
String of All Happy Strings of Length n
A happy string is a string that:
consists only of letters of the set
['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from
1 to s.length - 1 (string is 1-indexed).
https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
Example 1:
Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".

Example 2:
Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.

Example 3:
Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3
["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

Example 4:
Input: n = 2, k = 7
Output: ""*/
class Sln{
    void generatePermutation(char[] arr,int n,String res, List<String> l){
        if(n==0){
            l.add(res);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(res==""||res.charAt(res.length()-1)!=arr[i]){
                generatePermutation(arr,n-1,res+arr[i],l);
            }
        }
    }
    public String getHappyString(int n,int k){
        char[] arr={'a','b','c'};
        String res="";
        List<String> l=new ArrayList<>();
        generatePermutation(arr,n,res,l);
        if(l.size()>=k)
            res=l.get(k-1);
        return res;
    }
}