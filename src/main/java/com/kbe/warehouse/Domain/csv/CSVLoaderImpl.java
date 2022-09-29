package com.kbe.warehouse.Domain.csv;

import com.kbe.warehouse.Entity.Hardware;
import com.kbe.warehouse.Entity.HardwareType;
import com.kbe.warehouse.Entity.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVLoaderImpl implements CSVLoader{

    @Override
    public List<Hardware> loadHardwareListFromCsv(String path) {
        List<String[]> csvData = loadDataFromCsv(path);
        return getHardwareListFromCSVData(csvData);
    }

    @Override
    public List<Product> loadProductsFromCsv(String path, List<Hardware> hardwareList) {
        List<String[]> csvData = loadDataFromCsv(path);
        return getProductsFromCSVData(csvData, hardwareList);
    }

    private List<Hardware> getHardwareListFromCSVData(List<String[]> csvData){
        List<Hardware> hardwareList = new ArrayList<>();
        for (String[] line: csvData){
            Hardware hardware = createHardware(line);
            hardwareList.add(hardware);
        }
        return hardwareList;
    }

    private List<Product> getProductsFromCSVData(List<String[]> csvData, List<Hardware> hardwareList){
        List<Product> products = new ArrayList<>();
        for (String[] line: csvData){
            Product product = createProduct(line, hardwareList);
            products.add(product);
        }
        return products;
    }

    public List<String[]> loadDataFromCsv(String path) {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                dataList.add(attributes);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return dataList;
    }

    private Hardware createHardware(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        String description = formatComponentDescription(metadata[2]);
        float price = Float.parseFloat(metadata[3]);
        int stock = Integer.parseInt(metadata[4]);
        HardwareType productType = HardwareType.valueOf(metadata[5].toUpperCase());

        return new Hardware(id, productType, name , description, price, stock);
    }

    private Product createProduct(String[] metadata, List<Hardware> hardwareList) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        List<Hardware> productHardwareList = new ArrayList<>();

        for(int i = 2; i < metadata.length; i++){
            productHardwareList.add(hardwareList.get(Integer.parseInt(metadata[i])-1));
        }
        return new Product(id,name,productHardwareList);
    }

    private String formatComponentDescription(String str)
    {
        String newStr = str.replaceAll("\"","").replaceAll("/"," " + "");
        return String.join(" ",newStr.split("\""));
    }
}
