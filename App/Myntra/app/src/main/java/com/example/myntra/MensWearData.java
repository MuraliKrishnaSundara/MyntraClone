package com.example.myntra;

public class MensWearData {
    private int productImage;
    private String productName;
    private String productType;
    private String productCost;

    public MensWearData(int image, String name, String type, String cost) {
        this.productImage = image;
        productName = name;
        productType = type;
        productCost = cost;
    }

    public int getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductCost() {
        return productCost;
    }

}