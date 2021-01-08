package com.example.onlinelibrary;

import java.util.ArrayList;

public class AppListItem {
    private ArrayList<AppItem> items;

    public AppListItem( ArrayList<AppItem> items) {
        this.items=new ArrayList<>();
        this.items.addAll(items);
    }



    public ArrayList<AppItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<AppItem> items) {
        this.items = items;
    }
}
