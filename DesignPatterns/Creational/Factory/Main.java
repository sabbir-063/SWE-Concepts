package DesignPatterns.Creational.Factory;

// à§§. Product Interface 
interface Vehicle {
    void drive();
}

// à§¨. Concrete Products 
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car on the road ðŸš—...");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike on the road ðŸï¸");
    }
}

// à§©. Creator / Abstract Factory Class
abstract class VehicleFactory {
    public abstract Vehicle createVehicle();

    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.println("Vehicle ready for delivery!");
        vehicle.drive();
    }
}

// à§ª. Concrete Creators 
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

// à§«. Main Class (à¦à¦Ÿà¦¾à¦‡ à¦¶à§à¦§à§ public à¦¥à¦¾à¦•à¦¬à§‡)
public class Main {
    public static void main(String[] args) {
        
        VehicleFactory carFactory = new CarFactory();
        carFactory.deliverVehicle(); 
        
        System.out.println("-----------------");

        VehicleFactory bikeFactory = new BikeFactory();
        bikeFactory.deliverVehicle();
    }
}
