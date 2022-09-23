package com.kbe.warehouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LoadCsvToDB implements CommandLineRunner {

    static final String HARDWAREFILEPATH = "src/main/resources/Hardware.csv";
    static final String PRODUCTFILEPATH = "src/main/resources/Product.csv";
    private static HardwareRepository hardwareRepository;
    private static ProductRepository productRepository;
    private static List<Hardware> hardwareList = new ArrayList<>();


    public LoadCsvToDB(HardwareRepository hardwareRepository, ProductRepository productRepository){
        this.hardwareRepository = hardwareRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadAndSave();
    }

    private void loadAndSave(){
        loadHardwareFromCsv();
        //System.out.println(loadProductFromCsv());
        saveDataToDB(loadProductFromCsv());
    }

    private void loadHardwareFromCsv(){
        try (BufferedReader br = Files.newBufferedReader(Paths.get(HARDWAREFILEPATH))) {

            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(";");
                Hardware hardware = createHardware(attributes);
                hardwareList.add(hardware);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private List<Product> loadProductFromCsv() {

        List<Product> productList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(PRODUCTFILEPATH))) {

            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(";");
                Product product = createProduct(attributes);
                productList.add(product);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return productList;
    }

    private static Hardware createHardware(String[] metadata) {

        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        String description = formatComponentDescription(metadata[2]);
        float price = Float.parseFloat(metadata[3]);
        int stock = Integer.parseInt(metadata[4]);
        HardwareType productType = HardwareType.valueOf(metadata[5].toUpperCase());

        return new Hardware(id, productType, name , description, price, stock);
    }

    private static Product createProduct(String[] metadata) {

        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        List<Hardware> hardware = new ArrayList<>();

        for(int i = 2; i < metadata.length; i++){

            hardware.add( hardwareList.get(Integer.parseInt(metadata[i])));
        }
        return new Product(id,name,hardware);
    }

    private static String formatComponentDescription(String str)
    {
        String newStr = str.replaceAll("\"","").replaceAll("/"," " +
                "");

        return String.join(" ",newStr.split("\""));
    }

    private void saveDataToDB(List<Product> productList){

        hardwareRepository.saveAll(hardwareList);
        productRepository.saveAll(productList);

    }
}
