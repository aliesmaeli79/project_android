package com.example.onlinelibrary;

import java.util.ArrayList;

public class BannerListItem {

    private ArrayList<BannerItem> items;

    public BannerListItem(ArrayList<BannerItem> items) {
        this.items=new ArrayList<>();
        this.items.addAll(items);
    }

    public ArrayList<BannerItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BannerItem> items) {
        this.items = items;
    }

}
