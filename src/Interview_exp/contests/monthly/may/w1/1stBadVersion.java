/*You are a product manager and currently
leading a team to develop a new product. Unfortunately,
the latest version of your product fails the quality check.
Since each version is developed based on the previous version,
 all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want t
o find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which will return whether
 version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:
Given n = 5, and version = 4 is the first bad version.
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Sln extends VersionControl {
    public int firstBadVersion(int n) {
        int lo=1,hi=n,prev=-1;
        while (lo<=hi){
            int mi = ((hi-lo)>>1)+lo;
            if(isBadVersion(mi)) {
                prev = mi;
                hi = mi - 1;
            }
            else {
                lo = mi + 1;
                if(lo==prev) return lo;
            }
        }
        return lo;
    }
}