package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {

    @Test
    public void getMonthlyPayment_FinancedMonthlyPaymentPriceMoreThan10K_ThePaymentIsAsExpected(){

        //Arrange
        Vehicle vehicle = new Vehicle(243234, 3333, "dwfgwq", "gferget", "sedan", "black", 2512534, 25245);
        Contract contract = new SalesContract("5626234", "dfsghefgh", "ewfgewf@gmail.com", vehicle, true);

        //Act
        double monthlyPayment = contract.getMonthlyPayment();

        //Assert
        assertEquals(575.11, monthlyPayment);
    }

    @Test
    public void getMonthlyPayment_NotFinancedMonthlyPayment_ThePaymentIsAsExpected(){

        //Arrange
        Vehicle vehicle = new Vehicle(243234, 3333, "dwfgwq", "gferget", "sedan", "black", 2512534, 25245);
        Contract contract = new SalesContract("5626234", "dfsghefgh", "ewfgewf@gmail.com", vehicle, false);

        //Act
        double monthlyPayment = contract.getMonthlyPayment();

        //Assert

        assertEquals(0, monthlyPayment);
    }


    @Test
    public void getMonthlyPayment_NotFinancedMonthlyPaymentPriceLessThan10K_ThePaymentIsAsExpected(){

        //Arrange
        Vehicle vehicle = new Vehicle(243234, 3333, "dwfgwq", "gferget", "sedan", "black", 2512534, 2526);
        Contract contract = new SalesContract("5626234", "dfsghefgh", "ewfgewf@gmail.com", vehicle, true);

        //Act
        double monthlyPayment = contract.getMonthlyPayment();

        //Assert
        assertEquals(115.5, monthlyPayment);
    }

    @Test
    public void getTotalPrice_RegularTotalPrice_TheTotalPriceIsAsExpected(){

        //Arrange
        Vehicle vehicle = new Vehicle(243234, 3333, "dwfgwq", "gferget", "sedan", "black", 2512534, 2526);
        Contract contract = new SalesContract("5626234", "dfsghefgh", "ewfgewf@gmail.com", vehicle, true);

        //Act
        double totalPrice = contract.getTotalPrice();

        //Assert
        assertEquals(2626.05, totalPrice);
    }


}