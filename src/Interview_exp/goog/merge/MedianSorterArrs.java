/*LC4:Median of 2 sorted arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/
* There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5*/
class Sln{
    public double findMedianSortedArrays(int[] A,int[] B){
        int m=A.length,n=B.length;
        if(m>n){
            int[] tmp=A;A=B;B=tmp;
            int t=m;m=n;n=t;
        }
        int iMin=0,iMax=m,halfLen=(m+n+1)/2;
        while (iMin<=iMax){
            int i=(iMin+iMax)/2;
            int j=halfLen-1;
            if(i<iMax && A[i]<B[j-1]){
                iMin++;
            }
            else if(i>iMin && A[i-1]>B[j]){
                iMax--;
            }
            else { // i is perfect
                int maxLeft=0;
                if(i==0) { maxLeft=B[j-1];}
                else if(j==0){ maxLeft=A[i-1];}
                else { maxLeft=Math.max(A[i-1],B[j-1]);}
                if((m+n)%2==1) { return maxLeft;}
                int minRight=0;
                if(i==m){ minRight= B[j];}
                else if(j==n){ minRight=A[i];}
                else { minRight=Math.min(A[i],B[j]);}
                return (maxLeft+minRight)/2;
            }
        }
        return 0.0;
    }
}