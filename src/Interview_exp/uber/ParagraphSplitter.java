/*Write a function that takes a big message and splits it into
minimum number of smaller messages adhering to given limit.
While splitting the function should not split a word into
two messages. In the output messages please add tag ( x/y ).
The total length (including the tag) should not exceed the MaxLen
Input:
Message, MaxLen
The South Lake Union Streetcar is a streetcar route in Seattle, Washington, United States. Traveling 1.3 miles (2.1 km), it connects downtown to the South Lake Union neighborhood on Westlake Avenue, Terry Avenue, and Valley Street. It was the first modern Seattle Streetcar line, beginning service on December 12, 2007, two years after a separate heritage streetcar ceased operations. It was conceived as part of the redevelopment of South Lake Union into a technology hub, with lobbying and financial support from Paul Allen.
84
Output
Array of messages
1/7 The South Lake Union Streetcar is a streetcar route in Seattle, Washington,
2/7 United States. Traveling 1.3 miles (2.1 km), it connects downtown to the South
3/7 Lake Union neighbourhood on Westlake Avenue, Terry Avenue, and Valley Street. It
4/7 was the first modern Seattle Streetcar line, beginning service on December 12,
5/7 2007, two years after a separate heritage streetcar ceased operations. It was
6/7 conceived as part of the redevelopment of South Lake Union into a technology
7/7 hub, with lobbying and financial support from Paul Allen.*/
import java.util.ArrayList;
import java.util.List;
public class ParagraphSplitter {
    private static List<String> splitParagraph(String para, int splitSize) throws Exception {
        int paraLength = para.length();
        int totalSplits = paraLength % splitSize > 0 ? paraLength / splitSize + 1 : paraLength / splitSize;
        int totalSplitsDigits = String.valueOf(totalSplits).length();
        String remaining = para;
        int splitIndex = 0;
        List splits = new ArrayList();
        while (totalSplits != splitIndex) {
            //System.out.println("start totalSplits:"+ totalSplits);
            //System.out.println("start splitIndex:"+ splitIndex);
            if (splitIndex > 0) {
                totalSplits = splitIndex;
                totalSplitsDigits = String.valueOf(totalSplits).length();
            }
            splitIndex = 0;
            splits = new ArrayList();
            remaining = para;
            while (!remaining.isEmpty()) {
                splitIndex++;
                int extraChars = 2 + totalSplitsDigits + String.valueOf(splitIndex).length();
                int subStrLength = splitSize - extraChars;
                if (subStrLength  subStrLength ? remaining.substring(0, subStrLength - 1)
                        : remaining;
                //System.out.println("in progress split:"+ split);
                remaining = remaining.length() > subStrLength ? remaining.substring(subStrLength-1) : "";
                //System.out.println("in progress remaining:"+ remaining);
                while (!remaining.isEmpty() && !remaining.startsWith(" ")) {
                    if(split.length()==0) {
                        throw new Exception("Split Size is very less");
                    }
                    String adjustChar = String.valueOf(split.charAt(split.length()-1));
                    remaining = adjustChar.concat(remaining);
                    //System.out.println("in progress adjustChar:"+ adjustChar);
                    split =  split.substring(0, split.length()-1);
                    //System.out.println("in progress split:"+ split);
                    //System.out.println("in progress remaining:"+ remaining);
                }
                remaining = remaining.trim();
                StringBuilder sb = new StringBuilder(String.valueOf(splitIndex)).append('/').append(totalSplits)
                        .append(' ').append(split);
                splits.add(sb.toString());
            }
        }
        System.out.println("end totalSplits:"+ totalSplits);
        System.out.println("end splitIndex:"+ splitIndex);
        return splits;
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String para = "The South Lake Union Streetcar is a streetcar route in Seattle, Washington, United States. Traveling 1.3 miles (2.1 km), it connects downtown to the South Lake Union\n"
                       "neighborhood on Westlake Avenue, Terry Avenue, and Valley Street. It was the first modern Seattle Streetcar line, beginning service on December 12, 2007, two years after a separate heritage streetcar ceased operations. It was conceived as part of the redevelopment of South Lake Union into a technology hub, with lobbying and financial support from Paul Allen.";
        List<String> splits = ParagraphSplitter.splitParagraph(para, 90);
        System.out.println("Paragraph Splitter result:");
        for (String split : splits) {
            System.out.println(split);
        }
    }
}