class Solution {
    public boolean isValid(String s) {
        Stack<Character> par = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                par.push(map.get(c));
            } else if (map.containsValue(c)) {
                if (par.isEmpty() || par.pop() != c) {
                    return false;
                }
            }
        }
        return par.isEmpty();
    }
}