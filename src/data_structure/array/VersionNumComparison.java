/*LC165: Compare Version Numbers
https://leetcode.com/problems/compare-version-numbers/
Compare two version numbers version1 and version2.
If version1 > version2 return 1;
if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty
and contain only digits and the . character.

The . character does not represent a decimal point
and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or
"half way to version three", it is the fifth
second-level revision of the second first-level revision.

You may assume the default revision number for each level
of a version number to be 0. For example, version number
3.4 has a revision number of 3 and 4 for its first
and second level revision number. Its third and fourth
level revision number are both 0.

Example 1:
Input: version1 = "0.1", version2 = "1.1"
Output: -1

Example 2:
Input: version1 = "1.0.1", version2 = "1"
Output: 1

Example 3:
Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

Example 4:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”

Example 5:
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not
 have a third level revision number, which means its
 third level revision number is default to "0"*/
class Sln {
    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        // if pointer is set
        // to the end of string
        // return 0
        if (p > n - 1) {
            return new Pair(0, p);
        }
        // find the end of chunk
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }
        // retrieve the chunk
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        }
        else {
            i = Integer.parseInt(version.substring(p, n));
        }
        // find the beginning of next chunk
        p = pEnd + 1;
        return new Pair(i, p);
    }
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();

        // compare versions
        int i1, i2;
        Pair<Integer, Integer> pair;
        while (p1 < n1 || p2 < n2) {
            pair = getNextChunk(version1, n1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();

            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }
}

class Sln{
    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        if(p>n-1){
            return new Pair(0,p);
        }
        int i,pEnd=p;
        while (pEnd <n && version.charAt(pEnd)!='.'){
            pEnd++;
        }
        // retrieve the chunk
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        }
        else {
            i = Integer.parseInt(version.substring(p, n));
        }
        // find the beginning of next chunk
        p = pEnd + 1;
        return new Pair(i, p);
    }
    public int compareVersion(String v1,String v2){
        int p1=0,p2=0;
        int n1=s1.length(), n2=s2.length();
        int i1,i2;
        Pair<Integer,Integer> pair;
        while (p1<n1||p2<n2){
            pair=getNextChunk(v1,n1,p1);
            i1=pair.getKey();
            p1=pair.getValue();

            pair=getNextChunk(v2,n2,p2);
            i2=pair.getKey();
            p2=pair.getValue();
            if(i1!=i2){
                return i1>i2?1:-1;
            }
            //the versions are equal
            return 0;
        }

    }
}