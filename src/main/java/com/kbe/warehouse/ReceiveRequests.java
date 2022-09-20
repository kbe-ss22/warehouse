package com.kbe.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveRequests {

    @Autowired
    HardwareRepository hardwareRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products")
    public String receiveProductsRequest(){
        //zugriff auf productrepository
        String output = "whatever";
        return output;
    }

    @GetMapping(value = "/hardware")
    public String receiveHardwareRequest(){
        //zugriff auf hardwarerepository
        String output = "whatever";
        return output;
    }
}
