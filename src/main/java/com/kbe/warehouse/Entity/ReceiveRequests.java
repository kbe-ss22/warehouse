package com.kbe.warehouse.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiveRequests {

    @Autowired
    HardwareRepository hardwareRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/warehouse")
    public String receiveProductsRequest() throws JsonProcessingException {

        List<Hardware> hardwareList = (List<Hardware>) hardwareRepository.findAll();
        List<Product> productList = (List<Product>) productRepository.findAll();

        WarehouseRequestData wrd = new WarehouseRequestData(hardwareList,productList);

        //System.out.println(convertToJson(wrd));
        return convertToJson(wrd);
    }

    protected String convertToJson(WarehouseRequestData wrd) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(wrd);
        return json;
    }
}
