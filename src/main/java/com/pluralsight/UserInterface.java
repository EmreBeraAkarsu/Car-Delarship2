package com.pluralsight;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            //Added the option for new contract creation
            System.out.println("10. Enter a New Contract");
            System.out.println("99. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    //Calls the processANewContract method to run the code for new contract creation
                    processANewContract();
                    break;
                case "99":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void processANewContract(){

        //Prompt the user to enter if they need a lease or a sale contract
        System.out.println("Enter SALE for sale, LEASE for lease");
        String saleOrLease = scanner.nextLine();

        //Call the appropriate methods to instantiate correct type of contract
        if (saleOrLease.equalsIgnoreCase("sale")){
            processANewSale();
        }else if (saleOrLease.equalsIgnoreCase("lease")){
            processANewLease();
        }else {
            System.out.println("Incorrect input!");
        }
    }

    public void processANewSale(){
        //Prompt the user to enter the details of the sale contract
        System.out.println("Enter Date: ");
        String date = scanner.nextLine();

        System.out.println("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Customer Email: ");
        String email = scanner.nextLine();

        //Search the vehicle by the entered vin so the vehicle variable could be used in the contract
        System.out.println("Enter Vehicle Vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = dealership.getVehicleByVin(vin);

        //If cannot find a vehicle, return null
        if (vehicle == null){
            return;
        }


        System.out.println("Enter If It is Financed(yes/no): ");
        String isFinanceOption = scanner.nextLine();

        boolean isFinanced;

        //Validate and assign the value of the isFinanced variable according to the user's prompt
        if (isFinanceOption.equalsIgnoreCase("yes")){
            isFinanced = true;
        } else if (isFinanceOption.equalsIgnoreCase("no")) {
            isFinanced = false;
        }else {
            System.out.println("Incorrect finance option selected!");
            return;
        }

        //Instantiate a sales contract with the variables
        SalesContract salesContract = new SalesContract(date,name, email, vehicle, isFinanced);

        //Instantiate a contractFileManager object to write the contract to the file
        ContractFileManager contractFileManager = new ContractFileManager();

        //Save the contract by calling the saveContract() method in the ContractFileManager class
        contractFileManager.saveContract(salesContract);

        //Remove the vehicle from the dealership
        dealership.removeVehicle(vehicle);

    }

    public void processANewLease(){
        //Prompt the user to enter the details of the lease contract
        System.out.println("Enter Date: ");
        String date = scanner.nextLine();

        System.out.println("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Customer Email: ");
        String email = scanner.nextLine();

        //Search the vehicle by the entered vin so the vehicle variable could be used in the contract
        System.out.println("Enter Vehicle Vin: ");
        int vin = scanner.nextInt();

        Vehicle vehicle = dealership.getVehicleByVin(vin);

        //If cannot find a vehicle, return null
        if (vehicle == null){
            return;
        }

        //Make sure the vehicle entered is not older than 3 years
        if ((LocalDate.now().getYear() - vehicle.getYear()) > 3){
            System.err.println("Cannot Lease a Vehicle older than 3 years!");
            return;
        }

        //Instantiate a lease contract with the variables
        LeaseContract leaseContract = new LeaseContract(date, name, email, vehicle);

        //Instantiate a contractFileManager object to write the contract to the file
        ContractFileManager contractFileManager = new ContractFileManager();

        //Save the contract by calling the saveContract() method in the ContractFileManager class
        contractFileManager.saveContract(leaseContract);

        //Remove the vehicle from the dealership
        dealership.removeVehicle(vehicle);

    }
    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter vehicle vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();

        System.out.print("Enter vehicle mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle type (Car, Truck, SUV, Motorcycle): ");
        String type = scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);

        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter the VIN of the vehicle you wish to remove: ");
        int vin = scanner.nextInt();

        boolean vehicleRemoved = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                vehicleRemoved = true;
                break;
            }
        }

        if (!vehicleRemoved) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }

        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

}