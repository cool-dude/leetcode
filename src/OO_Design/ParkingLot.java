// Vehicle and its inherited classes.
public enum VehicleSize { Motorcycle, Compact,Large }
public abstract class Vehicle{
    protected List<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;
    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    public VehicleSize getSize(){
        return size;
    }
    /* Park vehicle in this spot (among others,
    potentially) */
    public void parkInSpot(ParkingSpot s){
        parkingSpots.add(s);
    }
    /* Remove vehicle from spot, and notify spot
    that it's gone */
    public void clearSpots() { ... }
    /* Checks if the spot is big enough for the
    vehicle (and is available).
    This * compares the SIZE only.It does not
    check if it has enough spots. */
    public abstract boolean canFitinSpot(ParkingSpot spot);
}

public class Bus extends Vehicle{
    public Bus(){
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }
    /* Checks if the spot is a Large. Doesn't check
     num of spots */
    public boolean canFitinSpot(ParkingSpot spot) {... }
}

public class Car extends Vehicle{
    public Car(){
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }
    /* Checks if the spot is a Compact or a Large. */
    public boolean canFitinSpot(ParkingSpot spot) { ... }
}

public class Motorcycle extends Vehicle{
    public Motorcycle(){
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }
    public boolean canFitinSpot(ParkingSpot spot) { ... }
}

public class ParkingSpot{
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;
    public ParkingSpot(Level lvl, int r, int n,
                       VehicleSize s)
    { ... }

    public boolean isAvailable(){
        return vehicle == null;
    }

    /* Check if the spot is big enough and is available */
    public boolean canFitVehicle(Vehicle vehicle) { ... }

    /* Park vehicle in this spot. */
    public boolean park(Vehicle v) {..}

    public int getRow(){
        return row;
    }

    public int getSpotNumber(){
        return spotNumber;
    }

    /* Remove vehicle from spot, and notify
      level that a new spot is available */
    public void removeVehicle() { ... }
}

/* Represents a level in a parking garage */
public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    // number of free spots
    private static final int SPOTS_PER_ROW = 10;
    public Level(int flr, int numberSpots) { ... }
    public int availableSpots() { return availableSpots; }
    /* Find a place to park this vehicle. Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) { ... }
    /* Park a vehicle starting at the spot spotNumber, */
    private boolean parkStartingAtSpot(int num, Vehicle v) { ... }
    /* Find a spot to park this vehicle. Return index of spot, or -1.*/
    private int findAvailableSpots(Vehicle vehicle) { ... }
    /* When a car was removed from the spot, increment 35  * availableSpots */
    public void spotFreed() { availableSpots++; }
}

public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;
    public ParkingLot() {}
    /* Park the vehicle in a spot (or multiple spots).
     * Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) { ... }
}