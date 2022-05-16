package com.kbe.warehouse;

import java.util.List;

public interface DataStorage {
    void saveProducts(List<Product> products);
    List<Product> getAllProducts();
    List<Product> getProductsOfType(ProductType type);
}
