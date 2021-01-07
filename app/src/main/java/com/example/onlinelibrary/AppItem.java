package com.example.onlinelibrary;

public class AppItem {

    private String name;
    private int img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public AppItem(String name, int img) {
        this.name = name;
        this.img = img;
    }


}