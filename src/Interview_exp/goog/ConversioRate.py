'''
Soln1: DFS
'''
class RateGraph(object):
    def __init__(self, rates):
        'Initialize the graph from an iterable of (start, end, rate) tuples.'
        self.graph = {}
        for orig, dest, rate in rates:
            self.add_conversion(orig, dest, rate)


    def add_conversion(self, orig, dest, rate):
        'Insert a conversion into the graph.'
        if orig not in self.graph:
            self.graph[orig] = {}
        self.graph[orig][dest] = rate


    def get_neighbors(self, node):
        'Returns an iterable of the nodes neighboring the given node.'
        if node not in self.graph:
            return None
        return self.graph[node].items()


    def get_nodes(self):
        'Returns an iterable of all the nodes in the graph.'
        return self.graph.keys()



from collections import deque
def __dfs_helper(rate_graph, node, end, rate_from_origin, visited):
    if node == end:
        return rate_from_origin

    visited.add(node)

    for unit, rate in rate_graph.get_neighbors(node):
        if unit not in visited:
            rate = __dfs_helper(rate_graph, unit, end, rate_from_origin * rate, visited)
            if rate is not None:
                return rate

    return None


def dfs(rate_graph, node, end):
    return __dfs_helper(rate_graph, node, end, 1.0, set())