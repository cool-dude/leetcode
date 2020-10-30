/*Given A, B, C, find any string of maximum
length that can be created such that no 3
consecutive characters are same.
There can be at max A 'a', B 'b' and C 'c'.

Example 1:
Input: A = 1, B = 1, C = 6
Output: "ccbccacc"

Example 2:
Input: A = 1, B = 2, C = 3
Output: "acbcbc"*/
class Sln{
    class Node{
        char ch;
        int val;
        public Node(int v,char c){
            val=v;
            ch=c;
        }
    }
    public String generateString(Map<Character, Integer> map){
        Queue<Node> q = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return b.val - a.val;
            }
        });
        for(Character l : map.keySet()){
            if(map.get(l) != 0){
                Node n = new Node(map.get(l) ,l);
                q.offer(n);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            Node first = q.poll();
            // System.out.println(res.toString());
            if(res.length() != 0 && res.charAt(res.length() - 1) == first.letter){
                if(q.isEmpty()){
                    return res.toString();
                }
                else{
                    Node second = q.poll();
                    res.append(second.letter);
                    second.val--;
                    if(second.val != 0){
                        q.offer(second);
                    }
                    q.offer(first);
                }
            }
            else{
                int limit = Math.min(2, first.val);
                for(int i = 0; i < limit; i++){
                    res.append(first.letter);
                    first.val--;
                }
                if(first.val != 0){
                    q.offer(first);
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 6);
        System.out.println(generateString(map));
    }
}