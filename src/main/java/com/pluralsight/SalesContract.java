package com.pluralsight;

public class SalesContract extends Contract {
    private static double salesTax = .05;
    private static double recordingFee = 100;
    private double processingFee;
    private boolean isFinance;

    private double totalPrice;
    private double monthlyPayment;

    //Constructor
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinance = isFinance;
    }

    //Getters and setters
    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return isFinance;
    }

    public void setFinance(boolean finance) {
        isFinance = finance;
    }

    //Method to get the total price of the vehicle with all the fees and taxes
    @Override
    public double getTotalPrice() {
        //Add vehicle price, tax, recordingFee, processing fee and return the total
        double totalPrice = getVehicleSold().getPrice() + salesTax + recordingFee + processingFee;
        this.totalPrice = totalPrice;
        return totalPrice;
    }

    //Method to get the monthly payment of the vehicle including all the taxes and fees
    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        double monthlyPayment = 0;
        //Continue here if the vehicle is financed
        if (isFinance) {
            //continue here if the vehicle value is greater than and equals to 10000
            if (getVehicleSold().getPrice() >= 10000) {
                //Set the appropriate variable values in this case
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                //Set the appropriate variable values in this case
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            //Find the monthly pay calculating with total price, interestRate, numberofPayments
            monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            //Round the monthly payment
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;

        }
        //Put the value into the class variable
        this.monthlyPayment = monthlyPayment;
        //Return value
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return "SALE|" + getDate() + "|" + getCustomerName() + "|" + getCustomerEmail() + "|" + getVehicleSold().getVin() + "|" + getVehicleSold().getYear() + "|" +
                getVehicleSold().getMake() + "|" + getVehicleSold().getModel() + "|" + getVehicleSold().getVehicleType() + "|" + getVehicleSold().getColor() + "|" +
                getVehicleSold().getOdometer() + "|" + getVehicleSold().getPrice() + "|" + salesTax + "|" + recordingFee + "|" + processingFee + "|" + totalPrice + "|" +
                isFinance + "|" + monthlyPayment;
    }
}
