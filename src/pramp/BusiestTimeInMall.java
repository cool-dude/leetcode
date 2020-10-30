package pramp;
public class BusiestTimeInMall {
    static int findBusiestPeriod(int[][] data) {
        if (data == null || data.length == 0)
            return -1;
        int curMax = 0;
        int currentPop = 0;
        int timeStamp = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            int[] dataPoint = data[i];
            int tStamp = dataPoint[0];
            int people = dataPoint[1];
            int enterOrExit = dataPoint[2];

            //int tempMax;
            if (enterOrExit == 1)
                currentPop = currentPop + people;
            else
                currentPop = currentPop - people;

            if (i < data.length - 1 && data[i + 1][0] == tStamp)
                continue;
            if (currentPop > curMax) {
                curMax = currentPop;
                timeStamp = tStamp;
            }
        }
        return timeStamp;
    }
    public static void main(String[] args) {
    }
}

public class Mall{
    static int findBusyPeriod(int[][] data){
        if(data==null || data.length==0)
            return -1;
        int curMax=0;
        int curPop=0;
        int timeStamp=Integer.MIN_VALUE;
        for(int i=0;i<data.length;i++){
            int[] arrP = data[i];
            int tStamp = arrP[0];
            int pop = arrP[1];
            int entryExit = arrP[2];

            if(entryExit==1)
                curPop += pop;
            else
                curMax -= pop;
            if(i<data.length && data[i+1][0]=tStamp)
                continue;
            if(curPop>curMax){
                curMax=curPop;
                timeStamp=tStamp;
            }
        }
        return timeStamp;
    }
}

