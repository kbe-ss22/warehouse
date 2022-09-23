package com.kbe.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class WarehouseRequestData {
    private List<Hardware> hardwareList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
}
