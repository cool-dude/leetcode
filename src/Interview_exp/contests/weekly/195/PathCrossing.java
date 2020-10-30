/*LC1496: Path Crossing
Given a string path, where path[i] = 'N', 'S', 'E' or 'W',
each representing moving one unit north, south, east, or west,
respectively. You start at the origin (0, 0) on a
2D plane and walk on the path specified by path.

Return True if the path crosses itself at any point,
that is, if at any time you are on a location
you've previously visited. Return False otherwise.

Example 1:
Input: path = "NES"
Output: false
Explanation: Notice that the path doesn't cross any point more than once.
Example 2:
Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.*/
class Sln{
    public boolean isPathCrossing(String path) {
        int x=0,y=0;
        Set<String> set=new HashSet<>();
        set.add(x+"$"+y);
        for(char c:path.toCharArray()){
            if(c=='N') y++;
            else if(c=='S') y--;
            else if(c=='E') x++;
            else x--;
            String cur=x+"$"+y;
            if(set.contais(cur)) return true;
            set.add(cur);
        }
        return false;
    }
}