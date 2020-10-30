There are N countries, each country has Ai players.
You need to form teams of size K such that each
player in the team is from a different country.
Given N and number of players from each country
and size K. Find the maximum number of teams you can form.

Similar question: https://leetcode.com/problems/rearrange-string-k-distance-apart/ (premium)*
*/
class Sln {
    public int maxNumberOfTeams(int[] countries, int k){
        if(countries==null||countries.length==0||k<=0) return 0;
        PriorityQueue<Integer> candidatePool=new PriorityQueue<Integer>(Collectios.reverseOrder());
        for(int country:countries){
            //Invalid input
            if(country<=0) return -1;
            candidatePool.offer(country);
        }
        int result=0;
        Stack<Integer> stack=new Stack<Integer>();
        while (candidatePool.size()>=k){
            for(int i=0;i<k;i++){
                int country=candidatePool.poll();
                if(--country>0) stack.push(country);
            }
            result++;
            while (!stack.empty()) candidatePool.offer(stack.pop());
        }
        return result;
    }
}