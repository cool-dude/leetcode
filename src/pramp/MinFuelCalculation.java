package pramp;

public class MinFuelCalculation {
    /*
    Drone Flight Planner
    You’re an engineer at a disruptive drone delivery startup and your CTO asks you to come up with an efficient algorithm that calculates the minimum amount of energy required for the company’s drone to complete its flight. You know that the drone burns 1 kWh (kilowatt-hour is an energy unit) for every mile it ascends, and it gains 1 kWh for every mile it descends. Flying sideways neither burns nor adds any energy.

    Given an array route of 3D points, implement a function calcDroneMinEnergy that computes and returns the minimal amount of energy the drone would need to complete its route. Assume that the drone starts its flight at the first point in route. That is, no energy was expended to place the drone at the starting point.

    For simplicity, every 3D point will be represented as an integer array whose length is 3. Also, the values at indexes 0, 1, and 2 represent the x, y and z coordinates in a 3D point, respectively.

    Explain your solution and analyze its time and space complexities.

    Example:

    input:  route = [ [0,   2, 10],
            [3,   5,  0],
            [9,  20,  6],
            [10, 12, 15],
            [10, 10,  8] ]

    output: 5 # less than 5 kWh and the drone would crash before the finish
          # line. More than `5` kWh and it’d end up with excess energy
    Constraints:

            [time limit] 5000ms

[input] array.array.integer route

1 ≤ route.length ≤ 100
            [output] integer

  */
    static int calcDroneMinEnergy(int[][] route) {

        // your code goes here

        int iEnergy = 0;
        int diff = 0;
        int initialHts = route[0][2];
        int curMin=0;
        for (int i = 1; i < route.length; i++) {
            int height = route[i][2]; // 0 6

            diff = initialHts - height;
            initialHts=height;
            iEnergy = iEnergy + diff;

            if(iEnergy<curMin)
                  curMin =iEnergy;

        }

        return curMin*(-1);
    }

    public static void main(String[] args) {
        int[][] input1 = new int[][]{
                {0, 2, 2},
                {3, 5, 38},
                {9, 20, 6},
                {10, 12, 15},
                {10, 10, 8}};


        int[][] input2 = new int[][]{
                {0, 2, 10},
                {3, 5, 0},
                {9, 20, 6},
                {10, 12, 15},
                {10, 10, 8}};

        System.out.println(calcDroneMinEnergy(input1));
        System.out.println(calcDroneMinEnergy(input2));
    }
}

class Soln{
    static int calcDroneMin(int[][] routes){
        int energy=0;
        int initHt=routes[0][2];
        int min=0;
        for(int i=1;i<routes.length;i++){
            int ht = routes[i][2];
            int dif = initHt-ht;
            initHt = ht;
            energy += dif;
            if(energy < min)
                min = energy;
        }
        return min<0?min*(-1):min;
    }

    public static void main(String[] args) {
        int[][] input1 = new int[][]{
                {0, 2, 2},
                {3, 5, 38},
                {9, 20, 6},
                {10, 12, 15},
                {10, 10, 8}};
        int[][] input2 = new int[][]{
                {0, 2, 10},
                {3, 5, 0},
                {9, 20, 6},
                {10, 12, 15},
                {10, 10, 8}};
        System.out.println(calcDroneMinEnergy(input1));
        System.out.println(calcDroneMinEnergy(input2));
    }
}