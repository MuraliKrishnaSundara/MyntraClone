package com.example.myntra;

public class shopProducts {
    private String productName;
    private String rating;
    private String companyName;
    private int price;
    private int picture;

    public shopProducts(String productName, String rating, String companyName, int price, int picture) {
        this.productName = productName;
        this.rating = rating;
        this.companyName = companyName;
        this.price = price;
        this.picture = picture;
    }

    public String getProductName() {
        return productName;
    }

    public String getRating() {
        return rating;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getPrice() {
        return price;
    }

    public int getPicture() {
        return picture;
    }
}
