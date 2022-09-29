package com.kbe.warehouse.Domain;

import com.kbe.warehouse.Domain.csv.CSVLoader;
import com.kbe.warehouse.Domain.db.DBHandler;
import com.kbe.warehouse.Entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadCSVDataToDBRunner implements CommandLineRunner {

    private static final String HARDWAREFILEPATH = "src/main/resources/Hardware.csv";
    private static final String PRODUCTFILEPATH = "src/main/resources/Product.csv";

    private DBHandler dbHandler;
    private CSVLoader csvLoader;


    public LoadCSVDataToDBRunner(DBHandler dbHandler, CSVLoader csvLoader){
        this.dbHandler = dbHandler;
        this.csvLoader = csvLoader;
    }

    @Override
    public void run(String... args){
        loadCSVDataToDB();
    }

    private void loadCSVDataToDB(){
        List<Hardware> hardwareList = csvLoader.loadHardwareListFromCsv(HARDWAREFILEPATH);
        List<Product> products = csvLoader.loadProductsFromCsv(PRODUCTFILEPATH, hardwareList);
        dbHandler.saveDataToDB(hardwareList, products);
    }
}
