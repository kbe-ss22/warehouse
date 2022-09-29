package com.kbe.warehouse.Domain.db;

import com.kbe.warehouse.Entity.Hardware;
import com.kbe.warehouse.Entity.Product;
import com.kbe.warehouse.Entity.db.HardwareRepository;
import com.kbe.warehouse.Entity.db.ProductRepository;
import com.kbe.warehouse.Entity.send.WarehouseRequestData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DBHandlerImpl implements DBHandler{

    @Autowired
    HardwareRepository hardwareRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public WarehouseRequestData getWarehouseRequestDataFromDB() {
        List<Hardware> hardwareList = (List<Hardware>) hardwareRepository.findAll();
        List<Product> productList = (List<Product>) productRepository.findAll();
        return new WarehouseRequestData(hardwareList,productList);
    }

    @Override
    public void saveDataToDB(List<Hardware> hardwareList, List<Product> products) {
        hardwareRepository.saveAll(hardwareList);
        productRepository.saveAll(products);
    }
}
