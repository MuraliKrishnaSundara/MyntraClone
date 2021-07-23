package com.example.myntra;

public class GadgetsData {
    private int gadgetsWearImage;
    private String gadgetsWearName;
    private String gadgetsWearType;
    private int gadgetsWearCost;

    public GadgetsData(int image, String name, String type, int cost) {
        this.gadgetsWearImage = image;
        gadgetsWearName = name;
        gadgetsWearType = type;
        gadgetsWearCost = cost;
    }

    public int getGadgetsWearImage() {
        return gadgetsWearImage;
    }

    public String getGadgetsWearName() {
        return gadgetsWearName;
    }

    public String getGadgetsWearType() {
        return gadgetsWearType;
    }

    public int getGadgetsWearCost() {
        return gadgetsWearCost;
    }

}