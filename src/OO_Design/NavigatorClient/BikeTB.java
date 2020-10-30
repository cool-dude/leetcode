//package com.company;
public class BikeTB implements TransportBehavior {
    final String type = "riding bike";

    public PathNode buildPath(Location A, Location B) {
        PathNode startPathNode = new PathNode(A);

        System.out.println("Building " + type + " path from " + A + " to " + B );

        return startPathNode;
    }
}