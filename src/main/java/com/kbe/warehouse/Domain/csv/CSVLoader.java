package com.kbe.warehouse.Domain.csv;

import com.kbe.warehouse.Entity.Hardware;
import com.kbe.warehouse.Entity.Product;

import java.util.List;

public interface CSVLoader {
    List<Hardware> loadHardwareListFromCsv(String path);
    List<Product> loadProductsFromCsv(String path, List<Hardware> hardwareList);
}
