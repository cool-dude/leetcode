/*Given a 2-D String array of student-marks find the student
with the highest average and output his average score.
If the average is in decimals, floor it down to the nearest integer.*/
class Sln{
    public int maxAverageName(String[][] names){
        if(names==null||names.length==0)
            return "";
        HashMap<String, List<Integer>> map=new HashMap<>();
        for(String[] name:names){
            map.put(name[0],map.getOrDefault(name[0],new ArrayList<>()).add(Integer.parseInt(name[1])));
        }
        int max=0;
        for(String name:map.keySet()){
            List<Integer> sList=map.get(name);
            int sum=0;
            for(int elm:sList) {
                sum += elm;
            }
            int avg=(int)(sum/sList.size());
            if(avg>max){
                max=avg;
            }
        }
        return max;
    }
    public int maxAverageScore(String[][] names){
        if(names==null||names.length==0)
            return -1;
        HashMap<String,int[]> map=new HashMap<>();
        for(String[] name:names){
            if(!map.containsKey(name[0]))
                map.put(name[0],new int[]{1,Integer.parseInt(name[1])});
            else
                map.put(name[0],new int[]{(map.get(name[0])[0]+1,(map.get(name[0]))[1]+Integer.parseInt(name[1])});
        }
        int max=0;
        for(int[] score:map.values()){
            max=Math.max(max, (int)(score[1]/score[0]));
        }
        return max;
    }
    //n: number of names in names string
    //k: number of students
    //T:O(n +k)=O(n).
    //S:O(k).
}