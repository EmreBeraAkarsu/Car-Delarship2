package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    private String fileName = "contracts.csv";

    public void saveContract(Contract contract){


        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write(contract.toString());
            bufferedWriter.newLine();

            System.out.println("Contract saved successfully to " + fileName);



        } catch (Exception e) {
            System.err.println("Error writing to the file!");;
        }


    }
}
