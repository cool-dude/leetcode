/*Given an array of sets find the one that does not belong:
example: [[a,b,c,d], [a,b,f,g], [a,b,h,i], [j,k,l,m]]
output: [j,k,l,m]

We can see above that the first three sets have a subset
* [a,b,c] and the last one does not. Note: There may be
* case where the outlier set does have elements contained
* in the input group. In this case we have the find
the set that has the least in common with the other sets.*/
class Sln{
    public char[] getMostUniqSet(char[][] sets){
        Map<Character,Integer> charMap=new HashMap<>();
        for(char[] set:sets)
            for(char c:set)
                charMap.put(c,charMap.getOrDefault(c,0)+1);
            char[] minArray=new char[0];
            int min=Integer.MAX_VALUE;
        for(char[] set:sets){
            int tempMin=0;
            for(char c:set)
                if(charMap.get(c)>1) tempMin++;
            //nothing common
            if(tempMin==0)
                return set;
            if(tempMin<min){
                min=tempMin;
                minArray=set;
            }
        }
        return minArray;
    }
    //T:O(n*L).
    //S:O(n*L).
}