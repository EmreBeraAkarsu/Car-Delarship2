package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaseContractTest {

    @Test
    public void getMonthlyPayment_GetTheRegularMonthlyPayment_MonthlyPyamentResultIsExpected(){

        //Arrange
        Vehicle vehicle = new Vehicle(243234, 3333, "dwfgwq", "gferget", "sedan", "black", 2512534, 25245);
        Contract contract = new LeaseContract("5626234", "dfsghefgh", "ewfgewf@gmail.com", vehicle);

        //Act
        double monthlyPayment = contract.getMonthlyPayment();

        //Assert
        assertEquals(424.84, monthlyPayment);

    }


    @Test
    public void getTotalPrice_GetTheRegularTotalPrice_TotalPriceResultIsExpected(){

        //Arrange
        Vehicle vehicle = new Vehicle(243234, 3333, "dwfgwq", "gferget", "sedan", "black", 2512534, 25245);
        Contract contract = new LeaseContract("5626234", "dfsghefgh", "ewfgewf@gmail.com", vehicle);

        //Act
        double totalPrice = contract.getTotalPrice();

        //Assert
        assertEquals(14389.65, totalPrice);

    }

}