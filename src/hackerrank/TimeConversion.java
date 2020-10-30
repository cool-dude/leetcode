/*Given a time in -hour AM/PM format, convert it to military (24-hour) time.
Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
Example:
Return '12:01:00'.
Return '00:01:00'.*/
package hackerrank;
public class TimeConversion {
    public static void main(String[] args) {
        String input = "07:05:45PM";
        String out = timeConversion(input);
        System.out.println(out);
    }
    static String timeConversion(String s) {
        if (s == null || s.length() == 0) return "";
        boolean isPM = isPM(s);
        String cleanStr = removeAMorPM(s);
        String[] strs = cleanStr.split(":");
        StringBuilder sb = new StringBuilder();
        String hh = strs[0];
        if (!isPM) {
            if (Integer.parseInt(hh) >= 12) hh = "00";
        }
        else {
            if (Integer.parseInt(hh) != 12){
                hh = String.valueOf(Integer.parseInt(strs[0]) + 12);
            }
            if (Integer.parseInt(hh) >= 24) hh = "00";
        }
        sb.append(hh);
        sb.append(":");
        sb.append(strs[1]);
        sb.append(":");
        sb.append(strs[2]);
        return sb.toString();
    }
    static boolean isPM(String input) {
        String out = input.substring(input.length() - 2, input.length());
        if (out.equalsIgnoreCase("PM"))
            return true;
        return false;
    }
    static String removeAMorPM(String str) {
        return str.substring(0, str.length() - 2);
    }
}