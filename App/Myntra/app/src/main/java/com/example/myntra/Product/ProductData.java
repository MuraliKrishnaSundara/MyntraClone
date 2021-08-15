package com.example.myntra.Product;

public class ProductData {
    private int productImage;
    private String productName;
    private String productType;
    private int productCost;
    private String size;


    public ProductData(int image, String name, String type, int cost) {
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