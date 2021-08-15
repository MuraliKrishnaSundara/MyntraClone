package com.example.myntra.NavBarAvtivity.Studio;

public class StudioData {
    private int pImageView;
    private String Name;
    private String Time;
    private int imageView;
    private String Like;
    private String Message;

    public StudioData(int pImageView, String name, String time, int imageView, String like, String message) {
        this.pImageView = pImageView;
        Name = name;
        Time = time;
        this.imageView = imageView;
        Like = like;
        Message = message;
    }

    public int getpImageView() {
        return pImageView;
    }

    public String getName() {
        return Name;
    }

    public String getTime() {
        return Time;
    }

    public int getImageView() {
        return imageView;
    }

    public String getLike() {
        return Like;
    }

    public String getMessage() {
        return Message;
    }

}