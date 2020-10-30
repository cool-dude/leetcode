//LC:28. Implement strStr(
/*Implement strStr().
  Return the index of the first
  occurrence of needle in haystack, or -1 if needle is not part of haystack.

  Example 1:
  Input: haystack = "hello", needle = "ll"
  Output: 2

  Example 2:
  Input: haystack = "aaaaa", needle = "bba"
  Output: -1*/
class Sln1{
    public int strStr(String h,String n){
        int L=n.length(), n=h.length();
        for(int start=0;start<n-L+1;++start){
            if(h.substring(start+L).equals(n))
                return start;
        }
        return -1;
    }
}
//T:O((N-L)*L).
//S:O(1).