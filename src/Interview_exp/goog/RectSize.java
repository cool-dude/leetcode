/*Given a rectangle with width 'W' and height 'H',
you have to fit a string 'S' in it with maximum possible font size


The font size ranges from 1 to 30
You are given two APIs:
    getCharacterWidth(char c , int font_size)
    getCharacterHeight(int font_size)
getCharacterWidth(char c , int font_size): returns the width of a character for a particular font size
getCharacterHeight(int font_size): returns the height of characters for a particular font size
 */

class Sln{
    public int maxFontSize(String s,int W,int H,int left,int right){
        if(left>right)
            return -1;
        int mid=(left+right)/2;
        int h=getCharacterHeight(mid);
        int w=0;
        for (char c:s.toCharArray())
            w+=getCharacterWidth(c,mid);
        if(h==H && w==W)
            return mid;
        else if(w>W && h>H)
            return maxFontSize(s,W,H,left,mid-1);
        else
            return maxFontSize(s,W,H,mid+1,right);
    }
    int main(){
        int size=maxFontSize("string",W,H,0,30);
    }
}