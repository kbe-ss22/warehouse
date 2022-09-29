package com.kbe.warehouse.Domain.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kbe.warehouse.Entity.send.WarehouseRequestData;

public class WarehouseToJsonConverterImpl implements WarehouseToJsonConverter{
    @Override
    public String convertWarehouseRequestDataToJson(WarehouseRequestData data) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "";
        try {
            json = ow.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
