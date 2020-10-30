class Sln {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int gcd = findGCD(freq);
        if (gcd == 1) return false;
        for (int substrings = 2; substrings <= gcd; substrings++) {
            if (isRepeated(s, substrings)) return true;
        }
        return false;
    }
    private boolean isRepeated(String s, int substrings) {
        String pattern = s.substring(0, s.length() / substrings);
        int i = 0; int j = 0;
        while (i < s.length()) {
            if (pattern.charAt(j) != s.charAt(i)) return false;
            i++; j++;
            j %= pattern.length();
        }
        return true;
    }
    private int findGCD(int[] freq) {
        int gcd = 1;
        if (freq.length == 1) gcd = freq[0];
        gcd = gcd(freq[0], freq[1]);
        for (int i = 2; i < freq.length; i++) {
            gcd = gcd(gcd, freq[i]);
        }
        return gcd;
    }
    private int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}