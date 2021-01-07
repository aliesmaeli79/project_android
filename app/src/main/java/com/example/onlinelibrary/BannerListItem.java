package com.example.onlinelibrary;

import java.util.ArrayList;

public class BannerListItem {

    private ArrayList<BannerItem> items;
    private String title;

    public BannerListItem(String title,ArrayList<BannerItem> items) {
        this.items=new ArrayList<>();
        this.items.addAll(items);
        this.title=title;
    }

    public ArrayList<BannerItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BannerItem> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
