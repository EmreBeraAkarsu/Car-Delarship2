package com.pluralsight;

public class SalesContract {
    private double salesTax = .5;
    private double recordingFee = 100;
    private double processingFee;
    private boolean isFinance;

    private double totalPrice;
    private double monthlyPayment;

    public SalesContract(boolean isFinance) {
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

    public double getTotalPrice(){


    }

    public double getMonthlyPayment(){


    }
}
