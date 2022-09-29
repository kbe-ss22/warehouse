package com.kbe.warehouse.Domain.converter;

import com.kbe.warehouse.Entity.send.WarehouseRequestData;

public interface WarehouseToJsonConverter {
    String convertWarehouseRequestDataToJson(WarehouseRequestData data);
}
