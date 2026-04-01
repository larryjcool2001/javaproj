package vehicleSystem;

import java.util.Scanner;

public class VehicleSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Select Vehicle Type:");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Truck");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){

                Car car = new Car();

                System.out.print("Enter Make: ");
                car.setMake(scanner.nextLine());

                System.out.print("Enter Model: ");
                car.setModel(scanner.nextLine());

                System.out.print("Enter Year: ");
                car.setYear(scanner.nextInt());

                System.out.print("Enter Number of Doors: ");
                car.setNumberOfDoors(scanner.nextInt());

                scanner.nextLine();

                System.out.print("Enter Fuel Type: ");
                car.setFuelType(scanner.nextLine());

                System.out.println("\nCar Details");
                System.out.println("Make: " + car.getMake());
                System.out.println("Model: " + car.getModel());
                System.out.println("Year: " + car.getYear());
                System.out.println("Doors: " + car.getNumberOfDoors());
                System.out.println("Fuel: " + car.getFuelType());
            }

            else if(choice == 2){

                Motorcycle bike = new Motorcycle();

                System.out.print("Enter Make: ");
                bike.setMake(scanner.nextLine());

                System.out.print("Enter Model: ");
                bike.setModel(scanner.nextLine());

                System.out.print("Enter Year: ");
                bike.setYear(scanner.nextInt());

                System.out.print("Enter Number of Wheels: ");
                bike.setNumberOfWheels(scanner.nextInt());

                scanner.nextLine();

                System.out.print("Enter Motorcycle Type: ");
                bike.setMotorcycleType(scanner.nextLine());

                System.out.println("\nMotorcycle Details");
                System.out.println("Make: " + bike.getMake());
                System.out.println("Model: " + bike.getModel());
                System.out.println("Year: " + bike.getYear());
                System.out.println("Wheels: " + bike.getNumberOfWheels());
                System.out.println("Type: " + bike.getMotorcycleType());
            }

            else if(choice == 3){

                Truck truck = new Truck();

                System.out.print("Enter Make: ");
                truck.setMake(scanner.nextLine());

                System.out.print("Enter Model: ");
                truck.setModel(scanner.nextLine());

                System.out.print("Enter Year: ");
                truck.setYear(scanner.nextInt());

                System.out.print("Enter Cargo Capacity (tons): ");
                truck.setCargoCapacity(scanner.nextDouble());

                scanner.nextLine();

                System.out.print("Enter Transmission Type: ");
                truck.setTransmissionType(scanner.nextLine());

                System.out.println("\nTruck Details");
                System.out.println("Make: " + truck.getMake());
                System.out.println("Model: " + truck.getModel());
                System.out.println("Year: " + truck.getYear());
                System.out.println("Cargo Capacity: " + truck.getCargoCapacity());
                System.out.println("Transmission: " + truck.getTransmissionType());
            }

            else{
                System.out.println("Invalid selection.");
            }

        }

        catch(Exception e){
            System.out.println("Invalid input. Please enter correct data.");
        }

        scanner.close();
    }
}
