/*LC1087:Brace Expansion
https://leetcode.com/problems/brace-expansion/
A string S represents a list of words.
Each letter in the word has 1 or more options.
If there is one option, the letter is represented as is.
If there is more than one option, then curly braces
 delimit the options. For example, “{a,b,c}”
 represents options [“a”, “b”, “c”].

For example, “{a,b,c}d{e,f}” represents the
list [“ade”, “adf”, “bde”, “bdf”, “cde”, “cdf”].*/
class Sln{
    void getPermutations(String prefix, String suffix, List<String> results) {
        if(suffix.length() == 0) {
            results.add(prefix);
            return;
        }
        StringBuffer sb = new StringBuffer(prefix);
        for(int i = 0; i < suffix.length(); i++) {
            if(suffix.charAt(i) != '{') {
                sb.append(suffix.charAt(i));
            }
            else {
                int end = suffix.indexOf('}');
                String[] parts = suffix.substring(i+1, end).split(",");
                for(String part : parts) {
                    getPermutations(sb.toString()+part, suffix.substring(end+1), results);
                }
                // The rest of the string will be handled by recursive calls
                break;
            }
        }
    }
    public String[] expand(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result.toArray(new String[0]);
        }
        getPermutations("", s, result);
        String[] out=new String[result.size()];
        for(int i=0;i<result.size();i++) out[i]=result.get(i);
        return out;
    }
}