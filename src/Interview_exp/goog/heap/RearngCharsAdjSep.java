class Key{
    int freq;
    char ch;
    Key(int f, char c){
        freq=f;
        ch=c;
    }
}

class KeyComparator implements Comparator<Key>{
    public int compare(Key k1,Key k2){
        if(k1.freq < k2.freq)
            return 1;
        else if(k1.freq > k2.freq)
            return -1;
        return 0;
    }
}

class Solution {
    final static int MAX_CHAR = 26;
    public String reorganizeString(String S) {
        int n=S.length();
        int[] count = new int[MAX_CHAR];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++)
            count[S.charAt(i)-'a']++;
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());

        for(char c='a';c<='z';c++)
            if(count[c-'a'] > 0)
                pq.offer(new Key(count[c-'a'], c));
        String str = "";
        Key prv = new Key(-1,'#');

        while(!pq.isEmpty()){
            Key k = pq.peek();
            pq.poll();
            str += k.ch;

            if(prv.freq > 0)
                pq.offer(prv);

            k.freq--;
            prv = k;
        }
        if(n!=str.length())
            return "";
        else
            return str;
    }
}

class Sln {
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}