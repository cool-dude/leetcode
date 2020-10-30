/*Design data structures for a very
large social network like Facebook
or Linkedln?
(Me-> Bob-> Susan-> Jason-> You)
Case1:Simplify the Problem (Not considering millions of people)
We can construct a graph by
treating each person as a node
and letting an edge between
two nodes indicate that the
two users are friends.
a)If we want to find the path
between two people, we start with
one person and do a simple
breadth-first search.
b)Alternatively, we can do
bidirectional breadth first search.
This means doing two BFS,
one from the source and one
from the destination. When
the searches collide, we know
we�ve found a path.

In the implementation,
we�ll use two classes to help us.
a)PathNode represents the path as we�re searching,
storing each Person and the previousNode
we visited in this path.
b)BFSData holds the data needed
for a BFS, such as the isVisited
hash table and the toVisit queue.*/
class PathNode{
    Person person = null;
    PathNode prevNode = null;
    public PathNode(Person p,
		PathNode prev){
        person = p;
        prevNode = prev;
    }
    public Person getPerson(){
        return person;
    }
    public Linkedlist<Person> collapse(boolean startsWithRoot){
        List<Person> path= new Linkedlist<Person>();
        PathNode node = this;
        while (node != null){
            if (startsWithRoot)
                path.addlast(node.person);
            else
                path.addFirst(node.person);
            node = node.previousNode;
        }
        return path;
    }
}
class BFSData{
    public Queue<PathNode>
		toVisit = new Linkedlist<PathNode>();
    public HashMap<Integer, PathNode>
		visited = new HashMap<Integer, PathNode>();
    public BFSData(Person root){
        PathNode srcPath =
			new PathNode(root, null);
        toVisit.add(srcePath);
        visited.put(root.getID(), srcePath);
    }
    public boolean isFinished(){
        return toVisit.isEmpty();
    }
}
LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people,
	int src, int dst){
    BFSData srcData=new BFSData(people.get(src));
	BFSData dstData=new BFSData(people.get(dst));
	while (!srcData.isFinished() && !dstData.isFinished()){
        /* Search out from source. */
        Person collision = searchlevel(people, srcData, dstData);
        if (collision != null)
            return mergePaths(srcData, dstData, collision.getID());
        /* Search out from destination. */
        collision = searchlevel(people, dstData, srcData);
        if (collision != null)
            return mergePaths(srcData, dstData, collision.getID());
    }
    return null;
}
/* Search one level and return collision, if any.*/
Person searchLevel(HashMap<Integer, Person> people,
                BFSData primary, BFSData secondary){
    /* We only want to search one level at a time. Count
       how many nodes are currently
       in the primary's level and only do that many nodes.
       We continue to add nodes to the end. */
    int count = primary.toVisit.size();
    for (int i= 0; i < count; i++){
        /* Pull out first node. */
        PathNode pathNode = primary.toVisit.poll();
        int personld = pathNode.getPerson().getID();

        /* Check if it's already been visited. */
        if (secondary.visited.containsKey(personid))
            return pathNode.getPerson();

        /* Add friends to queue. */
        Person person = pathNode. getPerson();
        List<Integer> friends = person.getFriends();
        for (int friendid : friends) {
            if (!primary.visited.containsKey(friendid)) {
                Person friend= people.get(friendld);
                PathNode next = new PathNode(friend, pathNode);
                primary.visited.put(friendld, next);
                primary.toVisit.add(next);
            }
        }
    }
    return null;
}

/* Merge paths where searches met at the connection. */
Linkedlist<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection){
    // endl -> source, end2 -> dest
    PathNode endl = bfsl.visited.get(connection);
    PathNode end2 = bfs2.visited.get(connection);
 
    Linkedlist<Person> pathOne = endl.collapse(false);
    Linkedlist<Person> pathTwo = end2.collapse(true);

    pathTwo.removeFirst(); // remove connection
    pathOne.addAll(pathTwo); // add second path
    return pathOne;
}
select AVG(Sales.TotalSale)
from Sales
group by Sales.SalesPerson;