package DesignPatterns.Creational.Factory;

// ১. Product Interface 
interface Vehicle {
    void drive();
}

// ২. Concrete Products 
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car on the road 🚗...");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike on the road 🏍️");
    }
}

// ৩. Creator / Abstract Factory Class
abstract class VehicleFactory {
    public abstract Vehicle createVehicle();

    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.println("Vehicle ready for delivery!");
        vehicle.drive();
    }
}

// ৪. Concrete Creators 
class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}

// ৫. Main Class (এটাই শুধু public থাকবে)
public class Main {
    public static void main(String[] args) {
        
        VehicleFactory carFactory = new CarFactory();
        carFactory.deliverVehicle(); 
        
        System.out.println("-----------------");

        VehicleFactory bikeFactory = new BikeFactory();
        bikeFactory.deliverVehicle();
    }
}
