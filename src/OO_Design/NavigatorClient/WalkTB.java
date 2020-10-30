//package com.company;
public class WalkTB implements TransportBehavior {
    final String type = "walking";
    public PathNode buildPath(Location A, Location B) {
        PathNode startPathNode = new PathNode(A);

        System.out.println("Building " + type + " path from " + A + " to " + B );

        return startPathNode;
    }
}