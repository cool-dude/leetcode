class Sln {
    public static long analyzeInvestments(String s) {
        long ans = 0;
        for (int begin = 0; begin < s.length() - 2; begin++) {
            Map<Character, Integer> map = new HashMap<>();
            int end = begin;
            while (end < s.length()) {
                Character end_char = s.charAt(end);
                if (end_char == 'A' || end_char == 'B' || end_char == 'C') {
                    map.put(end_char, map.getOrDefault(end_char, 0) + 1);
                }
                // once you have at least one share from
                // all the three given companies, you can
                // add any character/share towards the end,
                // and it would still satisfy the criteria.
                if (map.size() == 3) {
                    ans += (s.length() - end);
                    break;
                }
                end++;
            }
        }
        return ans;
    }
}