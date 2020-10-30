/*LC1452: People Whose List of Favorite Companies Is Not a Subset of Another List
https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
Given the array favoriteCompanies where favoriteCompanies[i]
is the list of favorites companies for the ith person (indexed from 0).

Return the indices of people whose list of favorite companies
is not a subset of any other list of favorites companies.
You must return the indices in increasing order.

Example 1:
Input: favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
Output: [0,1,4]
Explanation:
Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the person with index 0.
Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] and favoriteCompanies[1]=["google","microsoft"].
Other lists of favorite companies are not a subset of another list, therefore, the answer is [0,1,4].

Example 2:
Input: favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
Output: [0,1]
Explanation: In this case favoriteCompanies[2]=["facebook","google"] is a subset of favoriteCompanies[0]=["leetcode","google","facebook"], therefore, the answer is [0,1].

Example 3:
Input: favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
Output: [0,1,2,3]*/
class Solution {
    public List<Integer> peopleIndexes(List<List<String>> fcs) {
        List<Integer> res= new LinkedList<>();
        int l = fcs.size();
        int[] f = new int[l];
        for (int i=0; i<l; i++) f[i]=i;
        for (int i=0; i<l; i++){
            for (int j=i+1; j<l; j++){
                int a = find(f, i), b = find(f, j);
                if (f[a]==f[b]) continue;
                else if (contains(fcs.get(a), fcs.get(b))) f[b]=f[a];
                else if (contains(fcs.get(b), fcs.get(a))) f[a]=f[b];
            }
        }
        Set<Integer> set= new HashSet<>();
        for (int i: f) set.add(find(f, i));
        res.addAll(set);
        Collections.sort(res);
        return res;
    }
    public boolean contains(List<String> a, List<String> b){
        if (a.size()<=b.size()) return false;
        return a.containsAll(b);
    }
    public int find(int[] f, int i){
        while (f[i]!=i){
            f[i]=f[f[i]];
            i=f[i];
        }
        return i;
    }
}