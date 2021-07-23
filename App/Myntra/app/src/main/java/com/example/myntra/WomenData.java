package com.example.myntra;

public class WomenData {
    private int womensWearImage;
    private String womensWearName;
    private String womensWearType;
    private int womensWearCost;

    public WomenData(int image, String name, String type, int cost) {
        this.womensWearImage = image;
        womensWearName = name;
        womensWearType = type;
        womensWearCost = cost;
    }

    public int getWomensWearImage() {
        return womensWearImage;
    }

    public String getWomensWearName() {
        return womensWearName;
    }

    public String getWomensWearType() {
        return womensWearType;
    }

    public int getWomensWearCost() {
        return womensWearCost;
    }

}