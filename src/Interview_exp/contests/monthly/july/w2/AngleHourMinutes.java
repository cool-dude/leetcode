/*Given two numbers, hour and minutes. Return the
smaller angle (in degrees) formed between the hour and the minute hand.

Example 1:
Input: hour = 12, minutes = 30
Output: 165

Example 2:
Input: hour = 3, minutes = 30
Output: 75

Example 3:
Input: hour = 3, minutes = 15
Output: 7.5

Example 4:
Input: hour = 4, minutes = 50
Output: 155

Example 5:
Input: hour = 12, minutes = 0
Output: 0
Constraints:
1 <= hour <= 12
0 <= minutes <= 59
Answers within 10^-5 of the actual value will be accepted as correct.*/
class Sln {
    public double angleClock(int h, int m) {
        if (h <0 || m < 0 || h >12 || m > 60)
            System.out.println("Wrong input");
        if(h==12)
            h=0;
        if(m==60){
            m=0;
            h+=1;
            if(h>12)
                h-=12;
        }
        double hour_ang=0.5*(h*60+m);
        double min_ang=6*m;
        double angle=Math.abs(hour_ang-min_ang);
        angle=Math.min(360-angle,angle);
        return angle;
    }
}