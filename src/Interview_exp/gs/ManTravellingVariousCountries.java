/*A man is wants to travel N coutries using 3 mode of transport
i.e Plane, Ship, Helicopter cost of each of them is different for each coutry.
You need to minimize the total cost for travelling.
Condition : Person can't travel with same transport
for two cities continuosly and travelling is done in input specified order.*/
class Sln{
    public int minimalCost(int[][] cost){
        int n=cost.length;
        if(n==0||cost==null)
            return 0;
        int lastTransport=-1;
        int minCost=0;
        for(int i=0;i<n;i++){
            int curMinCost=Integer.MAX_VALUE;
            int curIdx=-1;
            for(int j=0;j<cost[i].length;j++){
                if(j!=lastTransport && cost[i][j]<curMinCost){
                    curIdx=j;
                    curMinCost=cost[i][j];
                }
            }
            lastTransport=curIdx;
            minCost+=curMinCost;
        }
        return minCost;
    }
}