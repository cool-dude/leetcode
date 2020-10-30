/*Here is the question, Please comment
if you find a decent logic to go around it.
Given two strings which are anagrams of each other,
you can swap characters from any one string to make it identical to another. Return the minimum number of swaps.
E.g S1 = abc, S2 = bac Swaps = 1: Pretty simple test case.
S1 = aabcdeer S2= aebcedra Swaps = 3*/
class Sln{
    public static int getMinSwap(String s1, String s2) {
        int res = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }
        }
        Map<Character, Stack<Integer>> map = new HashMap<>();
        for(int i=0;i<sb1.length();i++) {
            map.putIfAbsent(sb1.charAt(i), new Stack<>());
            map.get(sb1.charAt(i)).push(i);
        }
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<sb2.toString().length();i++) {
            lst.add(map.get(sb2.charAt(i)).pop());
        }
        boolean[] visited = new boolean[lst.size()];
        for(int i=0;i<lst.size();i++) {
            int cycleSize = 0;
            int j = i;
            while(!visited[j]) {
                visited[j] = true;
                j = lst.get(j);
                cycleSize++;
            }
            if(cycleSize > 0)
                res += cycleSize - 1;
        }
        return res;
    }
}