This can be modelled as a graph problem.
You can think of the words as nodes of the graph and two nodes
are connected

if/only if they are of same length and differ in one char.

You can preprocess the dictionary and create this graph, should look like:

stack  jack
|      |
|      |
smack  back -- pack -- pick

You can then have a mapping from
the word to the node representing the word,
for this you can use a hash table, height balanced BST ...

exists a path between the two graph nodes,
which can easily be done using BFS or DFS.
Once you have the above mapping in place,
all you have to do is see if there
So you can summarize the algorithm as:

preprocess the dictionary and create the graph.
Given the two inputs words w1 and w2
if length(w1) != length(w2)
    Not possible to convert
else
    n1 = get_node(w1)
    n2 = get_node(w2)

if(path_exists(n1,n2))
    Possible and nodes in the
    path represent intermediary words
else
    Not possible