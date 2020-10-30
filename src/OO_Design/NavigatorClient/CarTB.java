//package com.company;
public class CarTB implements TransportBehavior {
    final String type = "driving car";

    public PathNode buildPath(Location A, Location B) {
        PathNode startPathNode = new PathNode(A);

        System.out.println("Building " + type + " path from " + A + " to " + B );

        return startPathNode;
    }
}