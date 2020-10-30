/*
LC1418: Display Table of Food Orders in a Restaurant
Given the array orders, which represents the orders
that customers have done in a restaurant. More
specifically orders[i]=[customerNamei,tableNumberi,foodItemi]
where customerNamei is the name of the customer, tableNumberi
is the table customer sit at, and foodItemi is the item customer orders.

Return the restaurant's “display table”. The “display table” is
a table whose row entries denote how many of each food item each
table ordered. The first column is the table number and the
remaining columns correspond to each food item in alphabetical order.
The first row should be a header whose first column is “Table”,
followed by the names of the food items. Note that the customer
 names are not part of the table. Additionally, the rows
 should be sorted in numerically increasing order.

Example 1:

Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
Explanation:
The displaying table looks like:
Table,Beef Burrito,Ceviche,Fried Chicken,Water
3    ,0           ,2      ,1            ,0
5    ,0           ,1      ,0            ,1
10   ,1           ,0      ,0            ,0
For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
For the table 5: Carla orders "Water" and "Ceviche".
For the table 10: Corina orders "Beef Burrito".
Example 2:

Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
Explanation:
For the table 1: Adam and Brianna order "Canadian Waffles".
For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
Example 3:

Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]*/
class Sln{
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> dishes=new TreeSet<>();
        TreeMap<Integer, TreeMap<String, Integer>> mp=new TreeMap<>();
        for(List<String> l:orders){
            int table=Integer.parseInt(l.get(1));
            dishes.add(l.get(2));
            if(!mp.containeKey(table)) mp.put(table, new TreeMap<>());
            mp.get(table).put(l.get(2), mp.get(table).getOrDefault(l.get(2),0)+1);
        }
        List<String> list=new ArrayList<>();
        List<String> top=new ArrayList<>();
        top.add(0, "Table");
        for(String dish:dishes) top.add(s);
        list.add(top);
        for(Map.Entry<Integer, TreeMap<String, Integer>> e:mp.entrySet()){
            List<String> cur=new ArrayList<>();
            cur.add(""+e.getKey());
            for(String s:dishes){
                cur.add(""+e.getValue().getOrDefault(s,0));
            }
            list.add(cur);
        }
        return list;
    }
}
class Sln2 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        final Map<Integer, Map<String, Integer>> map = new HashMap<>();
        final Set<String> dishes = new HashSet<>();
        for (List<String> o : orders) {
            map.computeIfAbsent(Integer.parseInt(o.get(1)), v -> new HashMap<>())
                    .merge(o.get(2), 1, Integer::sum);
            dishes.add(o.get(2));
        }
        final List<String> sortedDish = new ArrayList<>(dishes);
        final List<Integer> tables = new ArrayList<>(map.keySet());
        Collections.sort(sortedDish);
        Collections.sort(tables);
        final List<List<String>> res = new ArrayList<>();
        for (Integer table : tables) {
            final List<String> append = new ArrayList<>(Collections.singleton(String.valueOf(table)));
            final Map<String, Integer> currTable = map.get(table);
            for (String s : sortedDish) {
                append.add(String.valueOf(currTable.getOrDefault(s, 0)));
            }
            res.add(append);
        }
        sortedDish.add(0, "Table");
        res.add(0, sortedDish);
        return res;
    }
}