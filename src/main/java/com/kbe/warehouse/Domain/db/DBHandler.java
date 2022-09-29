package com.kbe.warehouse.Domain.db;

import com.kbe.warehouse.Entity.Hardware;
import com.kbe.warehouse.Entity.Product;
import com.kbe.warehouse.Entity.send.WarehouseRequestData;

import java.util.List;


public interface DBHandler {

    WarehouseRequestData getWarehouseRequestDataFromDB();
    void saveDataToDB(List<Hardware> hardwareList, List<Product> products);
}
