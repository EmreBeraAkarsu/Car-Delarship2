package com.pluralsight;

public class LeaseContract extends Contract{
    private double excpectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    private double totalPrice;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

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

    public double getTotalPrice(){


    }

    public double getMonthlyPayment(){


    }

    @Override
    public String toString() {
        return "LEASE|" + getDate() + "|" + getCustomerName() + "|" + getCustomerEmail() + "|" + getVehicleSold().getVin() + "|" + getVehicleSold().getYear() + "|" +
                getVehicleSold().getMake() + "|" + getVehicleSold().getModel() + "|" + getVehicleSold().getVehicleType() + "|" + getVehicleSold().getColor() + "|" +
                getVehicleSold().getOdometer() + "|" + getVehicleSold().getPrice() + "|" + excpectedEndingValue + "|" + leaseFee + "|" + totalPrice + "|" + monthlyPayment;
    }
}
