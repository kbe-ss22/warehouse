package com.kbe.warehouse.Domain.Listener;

import com.kbe.warehouse.Domain.db.DBHandler;
import com.kbe.warehouse.Domain.converter.WarehouseToJsonConverter;
import com.kbe.warehouse.Entity.send.WarehouseRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReceiveRequests {

    @Autowired
    private DBHandler dbHandler;
    @Autowired
    private WarehouseToJsonConverter warehouseToJsonConverter;

    @GetMapping(value = "/warehouse")
    public String receiveProductsRequest() {
        WarehouseRequestData wrd = dbHandler.getWarehouseRequestDataFromDB();
        return warehouseToJsonConverter.convertWarehouseRequestDataToJson(wrd);
    }
}
