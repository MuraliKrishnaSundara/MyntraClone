package com.example.myntra;

public class MenData {
    private int mensWearImage;
    private String mensWearName;
    private String mensWearType;
    private int mensWearCost;

    public MenData(int image, String name, String type, int cost) {
        this.mensWearImage = image;
        mensWearName = name;
        mensWearType = type;
        mensWearCost = cost;
    }

    public int getMensWearImage() {
        return mensWearImage;
    }

    public String getMensWearName() {
        return mensWearName;
    }

    public String getMensWearType() {
        return mensWearType;
    }

    public int getMensWearCost() {
        return mensWearCost;
    }

}