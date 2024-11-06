package com.pluralsight;

public class SalesContract extends Contract {
    private static double salesTax = .05;
    private static double recordingFee = 100;
    private double processingFee;
    private boolean isFinance;

    private double totalPrice;
    private double monthlyPayment;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinance = isFinance;
    }

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

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (isFinance) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "SALE|" + getDate() + "|" + getCustomerName() + "|" + getCustomerEmail() + "|" + getVehicleSold().getVin() + "|" + getVehicleSold().getYear() + "|" +
                getVehicleSold().getMake() + "|" + getVehicleSold().getModel() + "|" + getVehicleSold().getVehicleType() + "|" + getVehicleSold().getColor() + "|" +
                getVehicleSold().getOdometer() + "|" + getVehicleSold().getPrice() + "|" + salesTax + "|" + recordingFee + "|" + processingFee + "|" + totalPrice + "|" +
                isFinance + "|" + monthlyPayment;
    }
}
