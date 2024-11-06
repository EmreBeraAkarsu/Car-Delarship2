package com.pluralsight;

public class LeaseContract extends Contract{
    //Class variables
    private double excpectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    private double totalPrice;

    //Constructor
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);

        this.excpectedEndingValue = getVehicleSold().getPrice() / 2;
        this.leaseFee = getVehicleSold().getPrice() * .07;
    }

    //Getters and setters
    public double getExcpectedEndingValue() {
        return excpectedEndingValue;
    }

    public void setExcpectedEndingValue(double excpectedEndingValue) {
        this.excpectedEndingValue = excpectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    //Method to get the total price of the vehicle with all the fees and taxes
    @Override
    public double getTotalPrice() {
        double totalPrice = (getVehicleSold().getPrice() - excpectedEndingValue) + leaseFee;
        this.totalPrice = totalPrice;
        return totalPrice;
    }

    //Method to get the monthly payment of the vehicle including all the taxes and fees
    @Override
    public double getMonthlyPayment() {
        //A 3 year lease
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;

        //Calculate monthlyPay with totalPrice, interestRate, numberOfPayments
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;

        //Put the value into the class variable
        this.monthlyPayment = monthlyPayment;
        //Return value
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return "LEASE|" + getDate() + "|" + getCustomerName() + "|" + getCustomerEmail() + "|" + getVehicleSold().getVin() + "|" + getVehicleSold().getYear() + "|" +
                getVehicleSold().getMake() + "|" + getVehicleSold().getModel() + "|" + getVehicleSold().getVehicleType() + "|" + getVehicleSold().getColor() + "|" +
                getVehicleSold().getOdometer() + "|" + getVehicleSold().getPrice() + "|" + excpectedEndingValue + "|" + leaseFee + "|" + totalPrice + "|" + monthlyPayment;
    }
}
