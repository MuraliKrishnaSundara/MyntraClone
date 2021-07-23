package com.example.myntra;

public class MenData {
    private int productImage;
    private String productName;
    private String productType;
    private int productCost;

    public MenData(int image, String name, String type, int cost) {
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

    public int getProductCost() {
        return productCost;
    }

}