package com.kbe.warehouse;

public class HardwareComponent {
    private String name;
    private String description;
    private float price;
    private int stock;
    private HardwareComponentType productType;

    public HardwareComponent(String name, String description, float price, int stock, HardwareComponentType productType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.productType = productType;
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

    @Override
    public String toString() {
        return "HardwareComponent{" + '\n' +
                "name='" + name + '\n' +
                ", description='" + description + '\n' +
                ", price=" + price +
                ", stock=" + stock + '\n' +
                ", productType=" + productType +
                '}'  + '\n'  + '\n';
    }
}
