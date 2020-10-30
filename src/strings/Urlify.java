package cracking_coding_int.chapter_one;
public class Urlify {
    public static void main(String[] args) {
        char[] ch = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
        int length = 7;
        System.out.println(replaceSpaces(ch, length));
    }
    private static String replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength = 0, i = 0;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }
        System.out.println("Space Count: " + spaceCount);
        newLength = length + (spaceCount * 2);
        str[newLength] = '\0';
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(str);
        return new String(str);
    }
}

class Sln{
    public static void replaceSpaces(char[] str,int trueLen){
        int spaceCount=0,idx;
        for(int i=0;i<trueLen;i++){
            if(str[i]==' ')
                spaceCount++;
        }
        idx=trueLen+spaceCount*2;
        str[idx]='\0';
        for(int i=str.length()-1;i>=0;i--){
            if(str[i]==' '){
                str[idx-1]='0';
                str[idx-2]='2';
                str[idx-3]='%';
                idx-=3;
            }
            else {
                str[idx-1]=str[i];
                idx=idx-1;
            }
        }
        return new String(str);
    }
    public static void findLastCharacter(char[] str){
        for(int i=str.length()-1;i>=0;i--){
            if(str[i]!=' ')
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
    }
}