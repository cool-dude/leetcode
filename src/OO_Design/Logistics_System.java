/*https://leetcode.com/discuss/interview-question/124640/Design-a-Logistics-System
We have to design a logistics system where a client
can place an order to get his/her items delivered
to a given destination .
We have to keep track of status of all the orders .
The admin of logistics charges some amount for delivering the orders (Items).

My Solution :
classes :
Vehicle (Extended by Truck, Bike )
Order
Item
Location (for geographical position of any point)
Client
Admin*/
public enum VehicleStatus {
    FREE,
    BUSY,
    NOT_WORKING;
}

public enum OrderStatus {
    DELIVERED ,
    PROCESSING ,
    CANCELLED;
}

public enum PaymentStatus {
    PAID,
    UNPAID;
}

public enum OrderPriority {
    LOW,
    MEDIUM,
    HIGH;
}

// for geographical position of any point
class Location {
    float longitude;
    float latitude;
}

// for the vehicles used for transportation
class Vehicle {
    int id;
    String vehicleNo;
    int capacity;
    Location current_position;
    VehicleStatus current_condition;
}

class Truck extends Vehicles{
}

class Bike extends Vehicles{
}

// a new order is created for
// each order place by any client
class Order{
    int order_id;
    OrderPriority priority_of_order;
    Client owner_order;
    Location destination;
    int amount_of_charge;
    List<Item> items;
    int total_weight;
    OrderStatus current_status;
    PaymentStatus status_of_payment;
    Time time_of_order_placed;
    Time time_of_delivery
}

// An order is List of Items
class Item {
    String name;
    int price;
    int volume;
    int weight;
}

class Client {
    int client_id;
    String name;
    Location adress;
}

class Admin {
    void take_order(Order order)
    void process_order(Order order)
    Location track_order(int order_id)
}