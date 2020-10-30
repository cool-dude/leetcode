/*756. Pyramid Transition Matrix
We are stacking blocks to form a pyramid.
Each block has a color which is a one letter string.
We are allowed to place any color block C on top of
two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.


We start with a bottom row of bottom, represented as a single string.
We also start with a list of allowed triples allowed.
Each allowed triple is represented as a string of length 3.
Return true if we can build the pyramid all the way to the top, otherwise false.

Example 1:
Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
Output: true
Explanation:
We can stack the pyramid like this:
   A
  / \
 G   E
/ \ / \
B   C   D


Example 2:
Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
Output: false
Explanation:
We can't stack the pyramid to the top.
Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.*/
class Sln{
    void getList(String bottom, int idx, StringBuilder sb, List<String> ls, Map<String, List<String>> map) {
        if (idx == bottom.length() - 1) {
            ls.add(sb.toString());
            return;
        }
        for (String s : map.get(bottom.substring(idx, idx+2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, ls, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    boolean helper(String bottom, Map<String, List<String>> map) {
        if(bottom.length() == 1) return true;
        for (int i = 0; i<bottom.length()-1; i++) {
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        }
        List<String> ls = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String s : ls) {
            if (helper(s, map)) return true;
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0,2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }
        return helper(bottom, map);
    }
}