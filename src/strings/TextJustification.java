/*LC68: Text Justification
Given an array of words and a width maxWidth,
format the text such that each line has exactly
maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is,
pack as many words as you can in each line.
Pad extra spaces ' ' when necessary so that each line
has exactly maxWidth characters.

Extra spaces between words should be distributed as
evenly as possible. If the number of spaces on a line do not divide
evenly between words, the empty slots on the left will
be assigned more spaces than the slots on the right.
For the last line of text, it should be left
justified and no extra space is inserted between words.

Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example",
"of", "text", "justification."]
maxWidth = 16
Output:
[
"This    is    an",
"example  of text",
"justification.  "
]

Example 2:
Input:
words = ["What","must","be",
"acknowledgment","shall","be"]
maxWidth = 16
Output:
[
"What   must   be",
"acknowledgment  ",
"shall be        "
]
Explanation: Note that the last line
is "shall be    " instead of "shall     be",
because the last line must be
left-justified instead of fully-justified.
Note that the second line is also
left-justified becase it contains only one word.

Example 3:
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
"to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
"Science  is  what we",
"understand      well",
"enough to explain to",
"a  computer.  Art is",
"everything  else  we",
"do                  "
] */
class Sln {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0, n = words.length;
        List<String> res = new ArrayList<>();
        while(i < n) {
            StringBuilder sb = new StringBuilder();
            int wordslen = 0;
            for(int j = i; j < n; j++) {
                wordslen += words[j].length();
                if(wordslen + j - i > maxWidth) {
                    wordslen -= words[j].length();
                    break;
                }
            }
            if(j - i == 1 || j == n) {
                for(int k = i; k < j; k++) {
                    if(k > i) sb.append(' ');
                    sb.append(words[k]);
                }
                for(int q = 0; q < maxWidth - wordslen - (j - i - 1); q++) {
                    sb.append(' ');
                }
            }
            else {
                int emp_count = maxWidth - wordslen;
                int avg = emp_count / (j - i - 1);
                int diff = emp_count - (j - i - 1) * avg;
                for(int k = i; k < j; k++) {
                    sb.append(words[k]);
                    int time = 0;
                    if(k < j - 1) time = diff-- > 0 ? avg + 1 : avg;
                    //System.out.println("i " + i + " j " + j + " k " + k + " " + time);
                    for(int q = 0; q < time; q++) sb.append(' ');
                }
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}

class Sln2 {
    List<String> getLineWords(String[] words, int i, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        String space = "";
        List<String> line = new ArrayList<>();

        while (i < words.length && (sb.length() + space.length() + words[i].length()) <= maxWidth) {
            sb.append(words[i] + space);
            line.add(words[i]);
            space = " ";
            i++;
        }
        return line;
    }
    String getLastLine(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (String w : line) {
            sb.append(sb.length() > 0 ? " " : "");
            sb.append(w);
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }
    String spaces(int count) {
        String sp = "";
        for (int j = 0; j < count; j++) {
            sp += " ";
        }
        return sp;
    }
    String justify(List<String> words, int maxWidth) {
        int count = 0;
        for (String w : words) count += w.length();
        StringBuilder sb = new StringBuilder();
        int spaces = maxWidth - count;
        if (words.size() == 1) {
            return words.get(0) + spaces(spaces);
        }

        int div = spaces / (words.size() - 1);
        int rem = spaces % (words.size() - 1);

        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                int spaceCount = Math.min(spaces, div);
                if (rem > 0) spaceCount++;

                sb.append(spaces(spaceCount));
                spaces -= div;
                rem--;
            }
            sb.append(words.get(i));
        }
        return sb.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length;) {
            List<String> line = getLineWords(words, i, maxWidth);
            i+= line.size();
            if (i == words.length) {
                res.add(getLastLine(line, maxWidth));
            }
            else {
                res.add(justify(line, maxWidth));
            }
        }
        return res;
    }
}