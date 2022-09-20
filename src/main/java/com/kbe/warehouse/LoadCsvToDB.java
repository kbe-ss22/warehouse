package com.kbe.warehouse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoadCsvToDB implements CommandLineRunner {


    HardwareRepository hardwareRepository;
    ProductRepository productRepository;

    public LoadCsvToDB(HardwareRepository hardwareRepository, ProductRepository productRepository){
        this.hardwareRepository = hardwareRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadAndSave();
    }

    private void loadAndSave(){
        //load data fromcsv
        //loadDataFromCsv();
        //save data to db
        //saveDataToDB();
    }

    private void loadDataFromCsv(){

    }

    private void saveDataToDB(){
        Hardware cpu = new Hardware();
        //cpu.setId(1);
        cpu.setName("ryzen7");
        cpu.setType("cpu");
        cpu.setDescription("8 cores");
        cpu.setPrice(222.52);
        cpu.setStock(5);

        Hardware gpu = new Hardware();
        //cpu.setId(1);
        cpu.setName("rx 6800");
        cpu.setType("gpu");
        cpu.setDescription("fast");
        cpu.setPrice(222.42);
        cpu.setStock(5);

        Product pc = new Product();
        pc.setName("wunder");
        List<Hardware> hardwareList = new ArrayList<>();
        hardwareList.add(cpu);
        hardwareList.add(gpu);
        pc.setHardware(hardwareList);

        hardwareRepository.save(cpu);
        hardwareRepository.save(gpu);

        productRepository.save(pc);
    }
}
