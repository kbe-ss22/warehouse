package com.kbe.warehouse;

import java.util.List;

public interface Warehouse {
    List<Product> getAllProducts();
    List<Product> getProductsOfType(ProductType type);
}
