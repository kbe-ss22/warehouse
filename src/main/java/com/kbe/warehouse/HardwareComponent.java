package com.kbe.warehouse;

public class HardwareComponent {
    private String name;
    private String description;
    private float price;
    private String location;
    private int stock;
    private HardwareComponentType productType;
    private String additionalAttributes;

    public HardwareComponent(String name, String description, float price, String location, int stock, HardwareComponentType productType, String additionalAttributes) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.location = location;
        this.stock = stock;
        this.productType = productType;
        this.additionalAttributes = additionalAttributes;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public HardwareComponentType getProductType() {
        return productType;
    }

    public void setProductType(HardwareComponentType productType) {
        this.productType = productType;
    }

    public String getAdditionalAttributes() {
        return additionalAttributes;
    }

    public void setAdditionalAttributes(String additionalAttributes) {
        this.additionalAttributes = additionalAttributes;
    }
}
