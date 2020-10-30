/*Question
In order to improve customer experience,
Amazon has developed a system to provide
recommendations to the customers regarding
the items they can purchase, Based on historical
customer purchase information, an item association
can be defined as - if an item A is ordered
by a customer, then item B is also likely to be
ordered by the same customer (e.g. Harry Potter 1 is frequently ordered with Harry Potter 2). All items that are linked together by an item association can be considered to be in the same group. An item without any association to any other item can be considered to be in its own item association group of size 1.

Given a list of item association relationships, write an algorithm that outputs the largest item association group. If two groups have the same number of items then select the group which contains the item that appears first in lexicographic order.

Input
The input to the function/method consists of an argument - itemAssociation a list containing pairs of items that are ordered together.

Output
Return a list representing the largest association group.

Example
Input:
itemAssociation:

[[Item1, Item2]
[Item3, Item4]
[Item4, Item5]*/
class Sln{
    public List<String> findAssociations(String[][] items){
        List<String> res=new ArrayList<>();
        if(items.size()==0)
            return res;
        for(String[] item:items){}
    }
}

class Solution {
    public List<List<String>> groupsMerge(List<List<String>> itasc) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 0; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}