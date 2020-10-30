/*https://leetcode.com/discuss/interview-question/542597/
Given a list of reviews, a list of keywords and an integer
* k. Find the most popular k keywords in order of most
* to least frequently mentioned.

The comparison of strings is case-insensitive.
* If keywords are mentioned an equal number of times
* in reviews, sort alphabetically.

Example 1:
Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews
* and "betacellular" is only occuring in 1 review.
Example 2:

Input:
k = 2
keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
reviews = [
  "I love anacell Best services; Best services provided by anacell",
  "betacellular has great services",
  "deltacellular provides much better services than betacellular",
  "cetracular is worse than anacell",
  "Betacellular is better than deltacellular.",
]

Output:
["betacellular", "anacell"]

Explanation:
"betacellular" is occuring in 3 different reviews.
* "anacell" and "deltacellular" are occuring in
* 2 reviews, but "anacell" is lexicographically smaller */
class Sln {
    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();
        for (String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for (String s : strs) {
                s = s.toLowerCase();
                if (set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue()
                ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while (!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = {"anacell", "cetracular", "betacellular"};
        String[] reviews1 = {"Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell",};
        int k2 = 2;
        String[] keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews2 = {"I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.",};
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }

    public static List<String> solve(int k,String[] keywords,String[] reviews){
        List<String> res=new ArrayList<>();
        Set<String> set=new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map=new HashMap<>();
        for(String r:reviews){
            String[] strs=r.split("\\W");
            Set<String> added=new HashSet<>();
            for(String s:strs){
                s=s.toLowerCase();
                if(set.contains(s)c && !added.contains(s)){
                    map.put(s, map.getOrDefault(s, map.getOrDefault(s,0)+1));
                    added.add(s);
                }
            }
        }
    }
}