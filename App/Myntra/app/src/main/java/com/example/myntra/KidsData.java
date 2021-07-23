package com.example.myntra;

public class KidsData {
    private int kidsWearImage;
    private String kidsWearName;
    private String kidsWearType;
    private int kidsWearCost;

    public KidsData(int image, String name, String type, int cost) {
        this.kidsWearImage = image;
        kidsWearName = name;
        kidsWearType = type;
        kidsWearCost = cost;
    }

    public int getKidsWearImage() {
        return kidsWearImage;
    }

    public String getKidsWearName() {
        return kidsWearName;
    }

    public String getKidsWearType() {
        return kidsWearType;
    }

    public int getKidsWearCost() {
        return kidsWearCost;
    }

}